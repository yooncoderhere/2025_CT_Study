const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const [n, ...input] = fs.readFileSync(filePath, 'utf-8').toString().trim().split('\n');

    const N = Number(n);

    const adj = Array.from({ length: N + 1 }, () => []);
    const parent = Array.from({ length: N });

    for (let i = 0; i < N; i++) {
        const [c, l, r] = input[i]
            .trim()
            .split(' ')
            .map((c) => {
                if (c === '.') {
                    return 0;
                } else {
                    return c.charCodeAt(0) - 64;
                }
            });

        if (l) parent[l] = c;

        if (r) parent[r] = c;

        adj[c].push(l);
        adj[c].push(r);
    }

    const preOrderTraversal = (res, currentNode) => {
        const [left, right] = adj[currentNode];

        res.push(String.fromCharCode(currentNode + 64));

        if (left) preOrderTraversal(res, left);
        if (right) preOrderTraversal(res, right);
    };

    const inOrderTraversal = (res, currentNode) => {
        const [left, right] = adj[currentNode];

        if (left) inOrderTraversal(res, left);

        res.push(String.fromCharCode(currentNode + 64));

        if (right) inOrderTraversal(res, right);
    };

    const postOrderTraversal = (res, currentNode) => {
        const [left, right] = adj[currentNode];

        if (left) postOrderTraversal(res, left);
        if (right) postOrderTraversal(res, right);
        res.push(String.fromCharCode(currentNode + 64));
    };

    const res1 = [];
    const res2 = [];
    const res3 = [];
    preOrderTraversal(res1, 1);
    inOrderTraversal(res2, 1);
    postOrderTraversal(res3, 1);
    console.log(res1.join(''));
    console.log(res2.join(''));
    console.log(res3.join(''));
};

solution();

// ABDCEFG
// DBAECFG
// DBEGFCA
