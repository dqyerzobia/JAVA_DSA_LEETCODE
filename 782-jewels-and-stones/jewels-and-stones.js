/**
 * @param {string} jewels
 * @param {string} stones
 * @return {number}
 */
var numJewelsInStones = function(jewels, stones) {
    let jewel = new Set();
    let cnt  = 0;

    for(let j of jewels){
        jewel.add(j);
    }

    for(let s of stones){
       if(jewel.has(s))cnt++;
    }

    return cnt;
};