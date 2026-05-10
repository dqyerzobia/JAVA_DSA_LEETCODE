class Solution {
    public boolean isPalindrome(int x) {
        int original = x;

        long rev = 0;

        while(x != 0){
            int dig = x % 10;
            rev = (rev  * 10) + dig;

            x /= 10;
        }

        if(original < 0 && rev < 0)return false;

        return (int) rev == original;
    }
}