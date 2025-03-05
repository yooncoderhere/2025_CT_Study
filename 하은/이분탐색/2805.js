const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').split('\n');

    const [N, M] = input[0].split(' ').map(Number);

    const trees = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    function binarySearch() {
        let low = 1;
        let high = trees[N - 1];

        let res = 0;
        while (low <= high) {
            let mid = Math.floor((low + high) / 2);

            let totalCut = 0;
            for (let i = 0; i < N; i++) {
                const currentTree = trees[i] > mid ? trees[i] - mid : 0;
                totalCut += currentTree;
            }

            if (totalCut >= M) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    return binarySearch();
};
console.log(solution());
