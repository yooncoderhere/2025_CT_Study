const stack = [];
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

function printStack() {
    console.log(stack.slice(0, top + 1).join(' '));
}

function NGE(num) {}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);
    const A = input[1].split(' ').map(Number);
    const res = [];

    for (let i = A.length - 1; i >= 0; i--) {
        while (!isEmpty() && A[i] >= peek()) {
            pop();
        }
        res.push(peek());
        push(A[i]);
    }

    return res.reverse().join(' ');
};

console.log(solution());
