const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');

    const N = Number(input[0]);
    const snowballs = input[1]
        .split(' ')
        .map(Number)
        .sort((a, b) => a - b);

    let min = Infinity;

    //눈덩이 두 개 선택
    for (let i = 0; i < N - 1; i++) {
        for (let j = i + 1; j < N; j++) {
            let left = 0,
                right = N - 1;

            while (left < right) {
                //이미 선택된 눈덩이라면, 그냥 넘어가야 함
                if (left === i || left === j) {
                    left++;
                    continue;
                }
                //이미 선택된 눈덩이라면, 그냥 넘어가야 함
                if (right === i || right === j) {
                    right--;
                    continue;
                }

                let snowman1 = snowballs[i] + snowballs[j];
                let snowman2 = snowballs[left] + snowballs[right];

                // min 갱신
                min = Math.min(min, Math.abs(snowman1 - snowman2));

                if (snowman2 < snowman1) left++;
                else right--;
            }
        }
    }

    return min;
};

console.log(solution());
