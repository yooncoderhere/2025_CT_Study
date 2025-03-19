const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const T = Number(input[0]);
    const A = input[2].split(' ').map(Number);
    const B = input[4].split(' ').map(Number);

    const ASlice = [];
    const BSlice = [];

    const partOfArr = (arr, saveArr) => {
        let sum = 0;
        for (let i = 0; i < arr.length; i++) {
            for (let j = i; j < arr.length; j++) {
                sum += arr[j];
                saveArr.push(sum);
            }
            sum = 0;
        }
    };

    partOfArr(A, ASlice);
    partOfArr(B, BSlice);

    ASlice.sort((a, b) => a - b);
    BSlice.sort((a, b) => a - b);

    const binarySearch = (arr, target) => {
        if (!target) return 1;

        const lowerBound = (arr, target) => {
            let start = 0;
            let end = arr.length;
            while (start < end) {
                let mid = Math.floor((start + end) / 2);
                if (arr[mid] >= target) end = mid;
                else start = mid + 1;
            }
            return start;
        };

        const upperBound = (arr, target) => {
            let start = 0;
            let end = arr.length;
            while (start < end) {
                let mid = Math.floor((start + end) / 2);
                if (arr[mid] > target) end = mid;
                else start = mid + 1;
            }
            return start;
        };
        return upperBound(arr, target) - lowerBound(arr, target);
    };

    let res = 0;
    for (let i = 1; i < T; i++) {
        res += binarySearch(ASlice, i) * binarySearch(BSlice, T - i);
    }

    return res;
};

console.log(solution());
