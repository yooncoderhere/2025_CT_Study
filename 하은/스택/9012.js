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

    #peek() {
        if (this.isEmpty()) {
            return -1;
        }

        return this.storage[this.top - 1];
    }

    isEmpty() {
        return this.top === -1;
    }
}

function solution() {
    let fs = require('fs');
    let filePath = process.platform === 'linux' ? '/dev/stdin' : '../../input.txt';
    let [N, ...input] = fs
        .readFileSync(filePath, 'utf-8')
        .trim()
        .split('\n')
        .filter((line) => line !== '.');

    let result = '';

    for (let line of input) {
        let stack = new Stack();
        let isVPS = true;

        for (let c of line) {
            if (c === '(') {
                stack.push('(');
            } else if (c === ')') {
                let res = stack.pop();

                if (res === -1) {
                    isVPS = false;
                    break;
                }
            }
        }

        if (stack.isEmpty() && isVPS) {
            result += 'YES\n';
        } else {
            result += 'NO\n';
        }
    }

    console.log(result);
}

solution();
