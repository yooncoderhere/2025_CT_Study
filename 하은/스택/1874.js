const stack = [];
let top = -1;

function isEmpty() {
    return top === -1;
}

function peek() {
    return top === -1 ? 0 : stack[top];
}
function push(item) {
    stack[++top] = item;
    return;
}

function pop() {
    if (!isEmpty()) {
        return stack[top--];
    }
    return false;
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const numbers = fs.readFileSync(filePath, 'utf-8').trim().split('\n').map(Number);

    const res = [];
    let currentNum = 1;

    for (let i = 1; i <= numbers[0]; i++) {
        const num = numbers[i];

        while (currentNum <= num) {
            push(currentNum);
            res.push('+');
            currentNum++;
        }

        if (peek() === num) {
            pop();
            res.push('-');
        } else {
            return 'NO';
        }
    }

    return res.join('\n');
};

console.log(solution().trim());
