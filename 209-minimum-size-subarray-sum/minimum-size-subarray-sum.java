class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int windowSum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++){
            windowSum  += nums[right];

            while(windowSum >= target){
                minLen = Math.min(minLen, right - left + 1);
                windowSum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}