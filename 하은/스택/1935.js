class Stack {
    constructor() {
        this.top = -1;
        this.stack = [];
    }

    isEmpty() {
        return this.top === -1;
    }

    push(item) {
        // console.log(item);
        this.stack[++this.top] = item;
    }

    pop() {
        if (!this.isEmpty()) {
            return this.stack[this.top--];
        }
    }

    showStack() {
        let res = [];
        for (let i = 0; i <= this.top; i++) {
            res.push(this.stack[i]);
        }
        console.log(res.join(''));
    }
}

function solution() {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const stack = new Stack();
    const values = input.slice(2).map((i) => Number(i));

    // 후위 표기식
    const postfix = input[1].trim();

    for (let c of postfix) {
        if ('+-*/'.includes(c)) {
            const right = stack.pop();
            const left = stack.pop();

            switch (c) {
                case '+':
                    stack.push(left + right);
                    break;
                case '-':
                    stack.push(left - right);
                    break;
                case '*':
                    stack.push(left * right);
                    break;
                case '/':
                    stack.push(left / right);
                    break;
            }
        } else {
            stack.push(values[c.charCodeAt(0) - 65]);
        }
    }
    return stack.stack[stack.top].toFixed(2);
}

console.log(solution());
