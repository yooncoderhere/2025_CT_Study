const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const [L, ...input] = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const res = [];

    for (let caseIdx = 0; caseIdx < L; caseIdx++) {
        const keyboardStr = input[caseIdx].split('');
        const N = keyboardStr.length;

        const dat = Array(N + 1).fill(0);
        const pre = Array(N + 1).fill(0);
        const nxt = Array(N + 1).fill(0);

        let unused = 1;
        let cursor = 0;

        dat[0] = pre[0] = nxt[0] = -1;

        function left() {
            if (cursor !== 0) cursor = pre[cursor];
        }

        function right() {
            if (nxt[cursor] !== -1) cursor = nxt[cursor];
        }

        function insert(data) {
            //node 만들기
            dat[unused] = data;
            pre[unused] = nxt[cursor];
            nxt[unused] = -1;

            // root인 경우
            if (nxt[cursor] === -1) {
                nxt[cursor] = unused;
                pre[unused] = cursor;
            } else {
                nxt[unused] = nxt[cursor];
                pre[unused] = cursor;

                pre[nxt[unused]] = unused;
                nxt[cursor] = unused;
                pre;
            }
            unused++;
            cursor = nxt[cursor];
        }

        function deleteFromDLL() {
            if (cursor === 0) return;
            else if (nxt[cursor] === -1) {
                nxt[pre[cursor]] = nxt[cursor];
            } else {
                nxt[pre[cursor]] = nxt[cursor];
                pre[nxt[cursor]] = pre[cursor];
            }

            cursor = pre[cursor];
        }

        for (let idx = 0; idx < N; idx++) {
            switch (keyboardStr[idx]) {
                case '<':
                    left();
                    break;
                case '>':
                    right();
                    break;
                case '-':
                    deleteFromDLL();
                    break;
                default:
                    insert(keyboardStr[idx]);
            }
        }
        function printDLL() {
            let idx = nxt[0];
            let res = [];
            while (idx !== -1) {
                res.push(dat[idx]);
                idx = nxt[idx];
            }

            return res.join('');
        }
        res.push(printDLL());
    }

    console.log(res.join('\n'));
};

solution();
