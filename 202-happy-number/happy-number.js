/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    const set = new Set();

    while(n != 1 && !set.has(n)){
        let sum = 0;
        set.add(n);

        while(n > 0){
            let dig = n % 10;
            sum = sum + (dig * dig);

            n = Math.floor(n / 10);
        }

        n = sum;
    }

    return n == 1;
};