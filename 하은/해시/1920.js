function solution() {
  //input
  const fs = require('fs');
  const filePath = process.platform === 'linux' ? '/dev/stdin' : '../../input.txt';
  const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

  const A = new Set(input[1].split(' '));
  const arr = input[3].split(' ');

  const res = arr.map(e => (A.has(e) ? 1 : 0));

  return res.join('\n');
}

console.log(solution());
