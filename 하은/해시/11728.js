const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    // const [N, M] = input[0].split(' ').map(Number);
    const A = input[1].split(' ').map(Number);
    const B = input[2].split(' ').map(Number);

    return [...A, ...B].sort((a, b) => a - b).join(' ');
};

console.log(solution());
