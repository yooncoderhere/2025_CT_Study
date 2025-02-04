const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const [N, C] = input[0].split(' ').map(Number);
    const map = new Map();

    //빈도수 카운팅
    input[1].split(' ').forEach((num) => {
        num = Number(num);
        if (!map.has(num)) {
            map.set(num, 1);
        } else {
            map.set(num, map.get(num) + 1);
        }
    });

    //빈도수 기준 정렬
    const res = Array.from(map)
        .sort((a, b) => b[1] - a[1])
        .map((item) => (item[0].toString() + ' ').repeat(item[1]));

    return res.join('');
};

console.log(solution());
