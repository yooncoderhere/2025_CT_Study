const stack = [];
let top = -1;

function isEmpty() {
    return top === -1;
}

function push(item) {
    // console.log(item);
    stack[++top] = item;
}

function pop() {
    if (!isEmpty()) {
        return stack[top--];
    }
}

function showStack() {
    return stack.slice(0, top + 1).join('');
}

function solution() {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const bomb = input[1];

    const bombLength = input[1].length;

    for (let c of input[0].trim()) {
        push(c);

        if (stack[top] === input[1][bombLength - 1]) {
            let isMatch = true;
            for (let i = top; i >= top - bombLength + 1; i--) {
                if (stack[i] !== bomb[bombLength - top + i - 1]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                for (let i = 0; i < bombLength; i++) {
                    pop();
                }
            }
        }
    }

    return top === -1 ? 'FRULA' : showStack();
}

console.log(solution());
