/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let letter  = new Set();
    let left = 0;
    let right = 0;

    let n = s.length;
    if(n == 0)return 0;

    if(n == 1)return 1;

    let maxLen = 0;

    while(right < n){
        while(letter.has(s[right])){
            letter.delete(s[left]);
            left++;
        }

        let Len = right - left + 1;
        maxLen = Math.max(maxLen, Len);

        letter.add(s[right]);
        right++;
    }

    return maxLen;
};