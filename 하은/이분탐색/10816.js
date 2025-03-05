const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').split('\n');

    const N = Number(input[0]);
    const cards = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    function binarySearch(target) {
        function upperIdx() {
            let start = 0;
            let end = N;

            //start와 end가 같아질 때까지
            while (start < end) {
                let mid = Math.floor((start + end) / 2); //중간 구하기
                if (cards[mid] > target) end = mid; //중간 인덱스의 값보다 타겟이 작으면 end에 mid를 넣는다.
                else start = mid + 1; //타겟보다 작거나 같은 경우 start에 mid + 1을 넣는다.
            }
            return end;
        }

        function lowerIdx() {
            let start = 0;
            let end = N;

            //start와 end가 같아질 때까지
            while (start < end) {
                let mid = Math.floor((start + end) / 2); //중간 구하기
                if (cards[mid] < target) start = mid + 1; //중간보다 큰 경우, start는 mid + 1
                else end = mid; // 중간보다 작거나 같은 경우, end는 중간
            }

            return start;
        }

        return upperIdx() - lowerIdx();
    }

    const numbers = input[3].split(' ').map((v) => binarySearch(Number(v)));

    return numbers.join(' ');
};

console.log(solution());
