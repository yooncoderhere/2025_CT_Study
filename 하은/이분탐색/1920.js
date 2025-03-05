const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').split('\n');

    const N = Number(input[0]);
    const A = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    function binarySearch(target) {
        let start = 0;
        let end = N;
        let mid = Math.floor((start + end) / 2);

        while (start <= end) {
            //존재하는 경우
            if (A[mid] === target) {
                return 1;
            }
            //mid보다 작은 경우
            else if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = Math.floor((start + end) / 2);
        }
        return 0;
    }

    const numbers = input[3].split(' ').map((v) => binarySearch(Number(v)));

    return numbers.join('\n');
};

console.log(solution());
