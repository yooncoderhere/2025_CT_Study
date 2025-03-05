const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const [, input] = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const numbers = input
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    const N = numbers.length;

    const algorithm = () => {
        let res = 0;

        for (let leftPos = 0; leftPos < N - 2; leftPos++) {
            for (let rightPos = leftPos + 2; rightPos < N; rightPos++) {
                let sum = numbers[leftPos] + numbers[rightPos];

                const upperBound = () => {
                    let start = leftPos + 1;
                    let end = rightPos;

                    while (start < end) {
                        let mid = Math.floor((start + end) / 2);
                        let total = sum + numbers[mid];

                        // mid보다 큰 값을 찾아야 하는 경우
                        if (total > 0) end = mid;
                        // mid보다 작은 값을 찾아야 하는 경우
                        else start = mid + 1;
                    }
                    return start;
                };

                const lowerBound = () => {
                    let start = leftPos + 1;
                    let end = rightPos;

                    while (start < end) {
                        let mid = Math.floor((start + end) / 2);
                        let total = sum + numbers[mid];

                        if (total >= 0) end = mid;
                        else start = mid + 1;
                    }
                    return start;
                };

                res += upperBound() - lowerBound();
            }
        }

        return res;
    };
    return algorithm();
};

console.log(solution());
