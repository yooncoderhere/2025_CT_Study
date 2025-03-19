const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? 'dev/stdin' : './input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').toString().trim().split('\n');

    const [N, R, Q] = input[0].split(' ').map(Number);

    const adj = Array.from({ length: N + 1 }, () => []);
    const parent = Array.from({ length: N + 1 }).fill(0);

    for (let i = 1; i < N; i++) {
        let [U, V] = input[i].split(' ').map(Number);

        adj[U].push(V);
        adj[V].push(U);
    }

    const childNum = Array.from({ length: N + 1 }).fill(0);

    const dfs = (currentNode) => {
        let cntChild = 0;
        for (let next of adj[currentNode]) {
            if (parent[currentNode] === next) continue;

            parent[next] = currentNode;
            cntChild++;
            cntChild += dfs(next);
        }
        childNum[currentNode] = cntChild;
        return cntChild;
    };

    dfs(R);

    const res = [];

    for (let i = N; i < N + Q; i++) {
        const U = Number(input[i]);

        res.push(childNum[U] + 1);
    }
    console.log(res.join('\n'));
};

solution();

/*
9 5 3
1 3
4 3
5 4
5 6
6 7
2 3
9 6
6 8
5
4
8
*/
