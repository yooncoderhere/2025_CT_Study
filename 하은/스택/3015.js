const stack = [];
let top = -1;

function push(item) {
    stack[++top] = item;
}

function pop() {
    if (top === -1) return -1;
    return stack[top--];
}

function size() {
    return top + 1;
}

function peek() {
    return size() ? stack[top] : -1;
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);
    const A = input[1].split(' ').map(Number);
    const res = [];

    for (let i = N - 1; i >= 0; i--) {
        while (size() && peek() <= A[i]) {
            pop();
        }
        res.push(peek());
        push(A[i]);
    }

    return res.reverse().join(' ');
};

//     return stack;
// };

console.log(solution());

// 2 4 1 2 2 5 1 /
// 2 4       5   / 처음 -> 첫 아이템은 무조건 push 그  다음부터는 peek과 비교하며 push를 해야함함
//   4 1 2   5   / 전 숫자(2)보다 큰 경우에는 2보다 작거나 같았던 숫자를 다시 push해야 함
//     1 2   5   / 작은 숫자의 경우 이전 숫자 (4)와 동일한데, 4가 빠진 형태를 갖는다.
//       2   5   / 2의 경우, 1보다는 크지만, 2와 같은수는 이미 있으므로 넣지 못함
//         2 5   / 2가 빠졌으니 2 들어올 수 잇음
//           5 1
