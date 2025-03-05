const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const [input, ...rest] = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const [universeNum, planetNum] = input.split(' ').map(Number);
    const universes = {};

    for (let r of rest) {
        const universe = Array.from(new Set(universes.split(' ').map(Number)).sorted((a, b) => a - b));
        universe.forEach((item, idx) => (universe[item] = idx));
    }

    console.log(universes);

    function binarySearch() {
        return null;
    }

    return binarySearch();
};
console.log(solution());
