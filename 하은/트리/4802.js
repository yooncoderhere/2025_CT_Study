const solution = () => {
    // 입력 처리
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').toString().trim().split('\n');

    let index = 0;
    let caseNum = 1;

    while (true) {
        // n: 노드의 개수 , m: 간선의 개수
        const [n, m] = input[index].split(' ').map(Number);
        if (n === 0 && m === 0) break; // 둘 다 0인 경우 끝
        index++;

        // 인접 리스트 생성
        const adj = Array.from({ length: n + 1 }, () => []);

        //방문 여부 저장
        const visited = Array(n + 1).fill(false);
        let treeCount = 0;

        // 간선 표시를 다 한 다음에
        for (let i = 0; i < m; i++) {
            const [u, v] = input[index].split(' ').map(Number);
            adj[u].push(v);
            adj[v].push(u);
            index++;
        }

        const isTree = (cur, parent) => {
            visited[cur] = true;

            for (const nxt of adj[cur]) {
                if (!visited[nxt]) {
                    if (!isTree(nxt, cur)) return false;
                } else if (nxt !== parent) {
                    return false; // 사이클 발생 시 트리가 아님
                }
            }

            return true;
        };

        for (let i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (isTree(i, -1)) treeCount++;
            }
        }

        if (treeCount === 0) {
            console.log(`Case ${caseNum}: No trees.`);
        } else if (treeCount === 1) {
            console.log(`Case ${caseNum}: There is one tree.`);
        } else {
            console.log(`Case ${caseNum}: A forest of ${treeCount} trees.`);
        }

        caseNum++;
    }
};

solution();
