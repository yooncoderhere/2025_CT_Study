const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const [_N, input] = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const numbers = input
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    const N = numbers.length;

    const twoPointer = () => {
        let start = 0;
        let end = N - 1;
        let min = Infinity;
        const pos = [numbers[start], numbers[end]];

        while (start < end) {
            let sum = numbers[start] + numbers[end];
            // console.log(numbers.slice(start, end + 1));
            // console.log(Math.abs(sum), min);

            if (Math.abs(sum) <= min) {
                min = Math.abs(sum);
                pos[0] = numbers[start];
                pos[1] = numbers[end];
            }

            if (sum > 0) end--;
            else start++;
            // else return pos;
        }
        return pos;
    };
    return twoPointer().join(' ');
};

console.log(solution());
