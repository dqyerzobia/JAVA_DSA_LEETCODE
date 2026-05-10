class Solution {
    static int n;
    static int [] dp;

    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        dp = new int [n];
        Arrays.fill(dp,-1);

        int res = solve(nums, 0, target);
        return res < 0 ? -1 : res;
    }

    public int solve(int [] arr, int i, int target){
        if(i == n-1)return 0;

        if(dp[i] != -1)return dp[i];

        int res  = Integer.MIN_VALUE;
        for(int j = i+1; j<n; j++){
            if(Math.abs(arr[i] - arr[j]) <= target){
                int temp = 1 + solve(arr,j,target);
                res = Math.max(res, temp);
            }
        }

        return dp[i] = res;
    }
}