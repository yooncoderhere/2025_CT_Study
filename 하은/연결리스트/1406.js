const fs = require('fs');

const filePath = process.platform === 'linux' ? '/dev/stdin' : '../../input.txt';
const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

function left() {
    // 커서가 맨 앞이면 무시
    if (cursor !== 0) cursor = pre[cursor];
}

function right() {
    //커서가 맨 뒤면 무시
    if (nxt[cursor] !== -1) cursor = nxt[cursor];
}

function eraseLeft() {
    //커서가 맨 앞이면 무시
    if (cursor === 0) {
        return;
    }

    // 1 2 3
    // 1이 3을 가리키도록록
    nxt[pre[cursor]] = nxt[cursor];

    //커서가 끝이 아니라면
    if (nxt[cursor] !== -1) {
        //커서의 뒷 노드가 앞 노드를 가리키도록 연결
        pre[nxt[cursor]] = pre[cursor];
    }
    //하나 지웠으니까 앞 노드로 이동
    cursor = pre[cursor];
}

function insertRight(dolor) {
    pre[unused] = cursor;
    nxt[unused] = nxt[cursor];
    nxt[cursor] = unused;

    if (nxt[cursor] !== -1) {
        //뒤에 노드가 없는 경우에는 pre[-1]이 되니까 이거 해주면 안됨
        pre[nxt[unused]] = unused;
    }

    dat[unused] = dolor;
    unused++;
    cursor = nxt[cursor];
}

//전체 출력
function showDLL() {
    let temp = nxt[0]; // 첫 번째 원소의 idx
    let result = '';

    while (temp !== -1) {
        result += dat[temp];
        temp = nxt[temp];
    }

    return result;
}

const N = input[0].length;
const str = input[0].split(''); //input
const M = Number(input[1]);
var cursor = N; //초기 커서의 위치
var unused = N + 1; // 메모리 공간 포인터

//연결리스트 세 개
var dat = Array(N + M).fill(0); // 값 저장
var pre = Array(N + M).fill(0); // 이전 노드의 위치
var nxt = Array(N + M).fill(0); //다음 노드의 위치

//초기 데이터 저장
// abc라면 -> a
for (let i = 0; i < N; i++) {
    dat[i + 1] = str[i];
    nxt[i + 1] = i + 2;
    pre[i + 1] = i;
}

//0 번째는 쓰지 않음
dat[0] = pre[0] = nxt[N] = -1;
nxt[0] = 1;

//명령어 입력 받는 부분
for (let i = 2; i < M + 2; i++) {
    let func = input[i].split(' ');

    if (func.length >= 2) {
        insertRight(func[1]);
    } else {
        switch (func[0]) {
            case 'L':
                left();
                break;
            case 'D':
                right();
                break;
            case 'B':
                eraseLeft();
                break;
        }
    }
}
console.log(showDLL());
