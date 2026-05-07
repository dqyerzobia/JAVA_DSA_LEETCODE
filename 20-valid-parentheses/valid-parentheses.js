/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let map = new Map();
    map.set(')', '(');
    map.set('}','{');
    map.set(']', '[');

    let stack = [];

    for(let ch of s){
        if([...map.values()].includes(ch)){
            stack.push(ch);
        }
        else if(map.has(ch)){
            if(stack.length == 0 || map.get(ch) != stack.pop())return false;
        }
    }

    return stack.length == 0;
};