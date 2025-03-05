const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').split('\n');

    const [nephewNum, N] = input[0].split(' ').map(Number);

    const snacks = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    function binarySearch() {
        let low = 1;
        let high = snacks[N - 1];

        let result = 0;

        while (low <= high) {
            let mid = Math.floor((low + high) / 2);

            let cnt = 0;
            for (let idx = 0; idx < N; idx++) cnt += Math.floor(snacks[idx] / mid);

            if (cnt >= nephewNum) {
                result = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return result;
    }

    return binarySearch();
};
console.log(solution());
