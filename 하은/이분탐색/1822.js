const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').split('\n');

    const [N_A, N_B] = input[0].split(' ').map(Number);

    const A = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    const B = input[2]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    function binarySearch(target) {
        let start = 0;
        let end = N_B - 1;

        while (start <= end) {
            let mid = Math.floor((start + end) / 2);

            if (target === B[mid]) return;
            else if (target > B[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return target;
    }

    const res = A.map((v) => binarySearch(Number(v))).filter((a) => a);

    return res.length ? `${res.length}\n`.concat(res.join(' ')) : '0';
};

console.log(solution());
