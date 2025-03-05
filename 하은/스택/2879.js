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
    //idx: 0위치 + 1 top: 배열의 끝끝
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
    //input
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);

    const currentIndent = input[1].split(' ').map(Number); //올바른 들여쓰기
    const correctIndent = input[2].split(' ').map(Number); //현재 들여쓰기 상황

    //들여쓰기의 차이를 저장하는 배열
    const indent = correctIndent.map((item, idx) => item - currentIndent[idx]);

    //최소한의 이동 횟수를 저장할 변수
    let totalShift = 0;

    for (let i = 0; i < N; i++) {
        // 부호를 체크 - 스택이 비었거나, peek()와 부호가 같다면 push
        if (isEmpty() || Math.sign(peek()) === Math.sign(indent[i])) {
            push(indent[i]);
        } else {
            //비어있지 않고, 부호가 다른 경우 -> 하나의 그룹으로 묶을 수 없음
            //가장 절댓값이 작은 값을 tab에 저장한 뒤 빼줘야 함. (peek() 계속하면서 0될 때까지)
            while (!isEmpty()) {
                if (peek() === 0) {
                    pop();
                } else {
                    //우측에서 가장 가까운 0의 인덱스
                    let indexOfZero = searchZero();

                    // 가장 절댓값이 작은 값 선택
                    let tab = stack[top];
                    for (let i = top; i > indexOfZero; i--) {
                        tab = Math.abs(tab) > Math.abs(stack[i]) ? stack[i] : tab;
                    }

                    //들여쓰기 이동,
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
