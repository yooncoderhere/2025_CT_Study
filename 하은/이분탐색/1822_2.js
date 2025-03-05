const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').split('\n');

    const [N_A, N_B] = input[0].split(' ').map(Number);

    const A = new Set(
        input[1]
            .split(' ')
            .map(Number)
            .sort((a, b) => a - b)
    );
    const B = new Set(
        input[2]
            .split(' ')
            .map(Number)
            .sort((a, b) => a - b)
    );

    const res = [];

    function difference() {
        A.forEach((a) => {
            if (!B.has(a)) res.push(a);
        });
    }

    difference();

    return res.length ? `${res.length}\n`.concat(res.join(' ')) : '0';
};

console.log(solution());
