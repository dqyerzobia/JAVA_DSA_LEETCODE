class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long [] prefix = new long [n];
        prefix[0] = nums[0];

        //prefix to get each subarray sum in O(1)
        for(int i = 1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        long res = Long.MIN_VALUE;

        //we can check all possible k length subarray till k
        for(int start = 0; start < k; start++){
            int i = start;
            long currSum = 0;

            while(i < n && i + k - 1 < n){
                int j = i + k - 1;
                long sum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);

                currSum = Math.max(sum, currSum + sum);
                res = Math.max(res, currSum);

                i+=k;
            }
        }

        return res;
    }
}