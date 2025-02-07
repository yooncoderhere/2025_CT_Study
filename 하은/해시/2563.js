const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    //색종이 개수
    const N = Number(input[0]);

    // 도화지 배열
    const paper = Array.from({ length: 100 }, () => Array(100).fill(false));

    //색종이 개수만큼 for문
    let cnt = 0;
    for (let i = 1; i <= N; i++) {
        const [x, y] = input[i].split(' ').map(Number);

        for (let curY = y; curY < y + 10; curY++) {
            for (let curX = x; curX < x + 10; curX++) {
                if (!paper[curY][curX]) {
                    paper[curY][curX] = true;
                    cnt++;
                }
            }
        }
    }

    return cnt;
};

console.log(solution());
