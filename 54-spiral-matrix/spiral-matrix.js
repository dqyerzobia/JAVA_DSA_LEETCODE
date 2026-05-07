/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    let m = matrix.length;
    let n = matrix[0].length;

    let totalElems = m * n;

    let top = 0;
    let bottom = m-1;
    let left = 0;
    let right = n-1;

    let res = [];

    while(totalElems > 0){
        for(let i = left; i<=right; i++){
            res.push(matrix[top][i]);
            totalElems--;
        }

        top++;

        for(let i = top; i<=bottom; i++){
            res.push(matrix[i][right]);
            totalElems--;
        }

        right--;

        if(top <= bottom){
            for(let i = right; i>=left; i--){
                res.push(matrix[bottom][i]);
                totalElems--;
            }

            bottom--;
        }

        if(left <= right){
            for(let i = bottom; i>=top; i--){
                res.push(matrix[i][left]);
                totalElems--;
            }

            left++;
        }
    }

    return res;
};