class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;

        if(n == 0)return "";

        StringBuilder res = new StringBuilder();

        for(String w: words){
            int weightSum = 0;
            for(char ch: w.toCharArray()){
                //get the weight value according to forward seq
                int weight = weights[ch - 'a'];
                weightSum += weight;
                weightSum %= 26;
            }
            
            //get the character from reverse seq odering acc. to computed weight
            res.append((char) ('z' - weightSum));
        }
        
        return res.toString();
    }
}