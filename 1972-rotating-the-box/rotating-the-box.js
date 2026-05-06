/**
 * @param {character[][]} boxGrid
 * @return {character[][]}
 */
const rotateTheBox = grid => {
    const rows = grid.length;
    const cols = grid[0].length;
    const res = Array.from({ length: cols }, () => Array(rows).fill('.'));

    for (let r = 0; r < rows; r++) {
        let p = cols - 1;
        for (let c = cols - 1; c >= 0; c--) {
            if (grid[r][c] === '*') {
                res[c][rows - 1 - r] = '*';
                p = c - 1;
            } else if (grid[r][c] === '#')
                res[p--][rows - 1 - r] = '#';
        }
    }

    return res;
};