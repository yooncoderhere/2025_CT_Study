function intersection(setA, setB) {
  const res = [...setA].filter(item => setB.has(item));
  return `${res.length}\n${res.sort().join('\n')}`;
}

const solution = () => {
  const fs = require('fs');
  const filePath = process.platform === 'linux' ? '/dev/stdin' : '../../input.txt';
  const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

  const [N, M] = input[0].split(' ').map(Number);
  const dName = new Set(input.slice(1, N + 1));
  const bName = new Set(input.slice(N + 1));

  return intersection(dName, bName);
};

console.log(solution());
