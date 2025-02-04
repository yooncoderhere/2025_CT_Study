const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const [K, L] = input[0].split(' ').map(Number);

    const list = new Map();
    input.slice(1, L + 1).forEach((id) => {
        // console.log(`id: ${id}`);
        if (list.has(id)) {
            list.delete(id);
        }
        list.set(id, 1);
    });

    // console.log(list);

    return Array.from(list)
        .filter((id) => id[1] === 1)
        .slice(0, K)
        .map((id) => id[0])
        .join('\n');
};

console.log(solution());
