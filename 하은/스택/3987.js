let stack = [];
let top = -1;

function push(item) {
    stack[++top] = item;
}

function isEmpty() {
    return top === -1;
}

function pop() {
    if (isEmpty()) return null;

    return stack[top--];
}

function peek() {
    return isEmpty() ? -1 : stack[top];
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);
    let cnt = 0;

    for (let i = 1; i <= N; i++) {
        line = input[i].split('');

        for (let idx = 0; idx < line.length; idx++) {
            let c = line[idx];
            if (peek() === c) {
                pop();
            } else {
                push(c);
            }
        }

        if (isEmpty()) {
            cnt++;
        }
        stack = [];
        top = -1;
    }

    return cnt;
};

console.log(solution());
