class Solution {
    static boolean  [] isPrime;
    public int countPrimes(int n) {
        if(n == 0 || n == 1)return 0;

        isPrime = new boolean [n];
        Arrays.fill(isPrime, true);

        buildSieve(n);
        int cnt = 0;

        for(int i = 0; i<n; i++){
            if(isPrime[i])cnt++;
        }

        return cnt;
    }

    public static void buildSieve(int n){
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i<n; i++){
            if(isPrime[i]){
                for(int j = i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}