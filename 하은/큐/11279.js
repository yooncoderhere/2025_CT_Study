class MaxHeap {
    constructor() {
        this.items = [];
    }

    size() {
        return this.items.length;
    }

    push(item) {
        this.items.push(item);
        this.bubbleUp();
    }

    pop() {
        if (!this.size()) return 0;

        const max = this.items[0];
        this.items[0] = this.items[this.size() - 1];
        this.items.pop();

        this.bubbleDown();
        return max;
    }

    swap(a, b) {
        [this.items[a], this.items[b]] = [this.items[b], this.items[a]];
    }

    bubbleUp() {
        let index = this.size() - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.items[parentIndex] >= this.items[index]) break; // 배열이 아니라 값 비교

            this.swap(parentIndex, index);
            index = parentIndex;
        }
    }

    bubbleDown() {
        let index = 0;
        while (index * 2 + 1 < this.size()) {
            let leftChild = index * 2 + 1;
            let rightChild = leftChild + 1;

            let maxChild =
                rightChild < this.size() && this.items[rightChild] > this.items[leftChild] ? rightChild : leftChild;

            if (this.items[index] >= this.items[maxChild]) {
                break;
            }

            this.swap(index, maxChild);
            index = maxChild;
        }
    }
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const [N, ...numbers] = fs.readFileSync(filePath, 'utf-8').trim().split('\n').map(Number);

    const maxHeap = new MaxHeap();
    const res = [];

    for (let i = 0; i < N; i++) {
        if (numbers[i]) {
            maxHeap.push(numbers[i]);
        } else {
            res.push(maxHeap.pop());
        }
    }

    return res.join('\n');
};

console.log(solution());
