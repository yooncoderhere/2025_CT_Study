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

function printStack() {
    console.log(`[${stack.slice(0, top + 1).join(' ')}]`);
}

function doIndent(idx, tab) {
    for (let i = idx; i <= top; i++) {
        stack[i] -= tab;
    }
}

function searchZero() {
    for (let i = top; i >= 0; i--) {
        if (stack[i] === 0) return i;
    }

    return -1;
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);
    const currentIndent = input[1].split(' ').map(Number);
    const correctIndent = input[2].split(' ').map(Number);

    const indent = correctIndent.map((item, idx) => item - currentIndent[idx]);
    let totalShift = 0;

    for (let i = 0; i < N; i++) {
        // 부호를 체크
        if (isEmpty() || Math.sign(peek()) === Math.sign(indent[i])) {
            push(indent[i]);
        } else {
            //비어있지 않고, 부호가 다른 경우
            //가장 절댓값이 작은 값을 tab에 저장한 뒤 빼줘야 함. (peek() 계속하면서 0될 때까지)
            while (!isEmpty()) {
                if (peek() === 0) {
                    pop();
                } else {
                    let indexOfZero = searchZero();

                    let tab = stack[top];
                    for (let i = top; i > indexOfZero; i--) {
                        tab = Math.abs(tab) > Math.abs(stack[i]) ? stack[i] : tab;
                    }

                    doIndent(indexOfZero + 1, tab);
                    totalShift += Math.abs(tab);
                }
            }
            push(indent[i]);
        }
    }

    while (!isEmpty()) {
        if (peek() === 0) {
            pop();
        } else {
            let indexOfZero = searchZero();

            let tab = stack[top];
            for (let i = top; i > indexOfZero; i--) {
                tab = Math.abs(tab) > Math.abs(stack[i]) ? stack[i] : tab;
            }

            doIndent(indexOfZero + 1, tab);
            totalShift += Math.abs(tab);
        }
    }

    // return res.join(' ');
    return totalShift;
};

console.log(solution());
