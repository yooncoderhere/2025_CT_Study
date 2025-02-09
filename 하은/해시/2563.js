const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const N = Number(fs.readFileSync(filePath, 'utf-8').trim());
    const min = 10 ** (N - 1);
    const max = 10 ** N - 1;

    //소수 확인 테이블
    const prime = new Array(10 ** N).fill(true);
    prime[1] = false;

    //에라토스테네스의 체
    for (let i = 2; i <= max; i++) {
        if (!prime[i]) continue;

        for (let j = i * 2; j <= max; j += i) {
            prime[j] = false;
        }
    }

    const res = [];

    //해당 자릿수만 확인
    for (let num = min; num <= max; num++) {
        //자릿수만큼 돌기
        for (let _num = num; _num >= 1; _num = Math.floor(_num / 10)) {
            // N의 자릿수
            if (!prime[_num]) break;
            if (_num < 10) res.push(num);
        }
    }

    return res.join('\n');
};

console.log(solution());
