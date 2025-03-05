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

    const N = Number(input[0]); // 탑의 개수
    const towers = input[1].split(' ').map(Number); // 탑들의 높이 배열

    const res = []; // 정답을 저장할 배열

    for (let i = 0; i < N; i++) {
        while (!isEmpty() && towers[i] >= towers[peek() - 1]) {
            pop(); // 현재 탑보다 작은 탑들은 모두 제거
        }

        res.push(peek()); // 수신할 탑이 없으면 0, 있으면 그 탑의 인덱스 (1부터 시작)

        push(i + 1); // 현재 탑의 번호(1부터 시작)를 스택에 추가
    }

    return res.join(' ');
};

console.log(solution());
