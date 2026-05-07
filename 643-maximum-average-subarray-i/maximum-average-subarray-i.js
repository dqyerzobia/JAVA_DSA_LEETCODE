/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let n = nums.length;
    let sum = 0;
    let maxSum = 0;

    for(let i = 0; i<k; i++){
        sum += nums[i];
    }

    maxSum = sum;

    for(let i = k; i<n; i++){
        sum = sum - nums[i-k] + nums[i];
        maxSum = Math.max(maxSum, sum);
    }

    return maxSum / k;
};