/*해시 테이블 클래스*/
class HashTable {
    constructor(size = 53) {
        //해시 테이블
        this.keyMap = new Array(size);
    }

    /*해시 함수는 체이닝 방식으로*/
    _hash(key) {
        let total = 0;
        let WEIRD_PRIME = 31; //소수를 사용해서 충돌을 줄이는 방식으로 구현

        for (let i = 0; i < Math.min(key.length, 500); i++) {
            //문자열의 각 문자를 아스키코드 값으로 바꾸고
            let char = key[i];
            let value = char.charCodeAt(0) - 96;

            //토탈에 합하는 식으로 구현
            //모듈러 연산을 통해 0 ~ 배열의 크기 - 1 사이의 값 반환을 보장
            total = (total * WEIRD_PRIME + value) % this.keyMap.length;
        }
        return total;
    }

    set(key) {
        const index = this._hash(key);

        //해당 인덱스에 아무것도 존재하지 않으면,빈 배열 생성
        if (!this.keyMap[index]) {
            this.keyMap[index] = [];
        } else {
            const list = this.keyMap[index];

            for (let num in list) {
                if (num === key) {
                    this.keyMap[index][key]++;
                    return;
                }
            }
        }
        this.keyMap[index][key] = 1;
    }

    get(key) {
        // key를 해시함수에 넣어서 나오는 인덱스에 접근해서 list에 담아옴
        const list = this.keyMap[this._hash(key)];
        if (list) {
            for (let num in list) {
                if (num === key) {
                    return list[num];
                }
            }
        }
        //존재하지 않으면, 0 반환
        return 0;
    }
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const N = Number(input[0]);

    /*상근이가 갖고 있는 숫자 카드*/
    const hashTable = new HashTable(N);
    input[1]
        .trim()
        .split(' ')
        .forEach((num) => hashTable.set(num));

    /*상근이가 갖고 있는지 확인할 숫자 카드들*/
    const res = input[3]
        .trim()
        .split(' ')
        .map((num) => hashTable.get(num));

    return res.join(' ');
};

console.log(solution());
