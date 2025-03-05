const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const A = input
    .slice(1)
    .map(Number)
    .sort((a, b) => a - b);
