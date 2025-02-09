class Stack {
    constructor() {
        this.storage = [];
        this.top = -1;
    }

    push(value) {
        this.storage[++this.top] = value;
    }

    pop() {
        if (this.isEmpty()) {
            return -1;
        }

        return this.storage[this.top--];
    }

    size() {
        return this.top + 1;
    }

    isEmpty() {
        return this.top === -1;
    }
}

function solution() {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : '../../input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('');

    const stack = new Stack();
    let cnt = 0;

    for (let idx = 0; idx < input.length; idx++) {
        if (input[idx] === ')') {
            cnt += 1;
            stack.pop();
        } else {
            if (input[idx] === '(' && input[idx + 1] === ')') {
                cnt += stack.size();
                idx++;
            } else {
                stack.push(input[idx]);
            }
        }
    }

    console.log(cnt);
}

solution();
