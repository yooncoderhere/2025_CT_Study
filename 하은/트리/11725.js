/* 트리의 부모 찾기 */

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').toString().trim().split('\n');

    // 노드의 개수
    const n = Number(input[0]);

    // 인접 노드 정보 저장
    const adj = Array.from({ length: n + 1 }, () => []);
    const parent = Array.from({ length: n }).fill(0);

    for (let i = 1; i < n; i++) {
        const [n1, n2] = input[i].split(' ').map(Number);

        // 연결 정보 저장장
        adj[n1].push(n2);
        adj[n2].push(n1);
    }

    const dfs = (currentNode) => {
        for (let next of adj[currentNode]) {
            if (parent[currentNode] === next) continue;

            parent[next] = currentNode;
            dfs(next);
        }
    };

    dfs(1);

    console.log(parent.slice(2).join('\n'));
};

solution();

// 1 - 6 - 3 - 5
// |
// 4 - 2
// |
// 7
