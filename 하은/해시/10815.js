const solution = () => {
  const fs = require('fs');
  const filePath = process.platform === 'linux' ? '/dev/stdin' : '../../input.txt';
  const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

  const cards = new Set(input[1].split(' '));
  const res = input[3].split(' ').map(element => (cards.has(element) ? 1 : 0));

  return res.join(' ');
};

console.log(solution());
