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
    return isEmpty() ? 0 : stack[top];
}

function printStack() {
    console.log(stack.slice(0, top + 1).join(' '));
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);
    const towers = input[1].split(' ').map(Number);
    const res = [];

    for (let i = 0; i < N; i++) {
        while (!isEmpty() && towers[i] >= towers[peek() - 1]) {
            pop();
        }
        res.push(peek());
        push(i + 1);
    }

    return res.join(' ');
};

console.log(solution());
