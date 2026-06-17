class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        //virtually keep a mathematical length;
        long L = 0;

        //first iteration to apply all the operation and 
        //compute the length based on them 

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                //delete a char i.e length will decrease
                L = (L > 0)? L-1 : L;
            }
            else if(ch == '#'){
                //double the string i.e add to itself
                L *= 2;
            }
            else if(ch == '%'){
                //no changhe 
                continue;
            }
            else{
                //add a simple char
                L++;
            }
        }

        //cehck whether the given k is still out of bound
        if(k >= L)return '.';

        //backtrack on the string basis of computed length
        for(int i = n-1; i>=0; i--){
            char ch = s.charAt(i);

            if(ch == '*'){
                //as we have already decrease it before 
                // it require to gain its original L as we are 
                // backtracking on original String

                L++;
            }
            else if(ch == '#'){
                //divide the String and recompute the k position 
                // on resultant string
                L /= 2;
                k = (k >= L)? k - L : k;
            }
            else if(ch == '%'){
                //if we reversed it the kth position char might
                //have changed find it
                k = L - k - 1;
            }
            else{
                //during backtracking keep removing normal char until wereach our desired kth char
                L--;
            }
            
            //Length reached at k
            if(k == L){
                return ch;
            }
        }

        return '.';
    }
}