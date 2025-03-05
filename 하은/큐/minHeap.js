class MinHeap {
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
        if (!this.size()) return null;

        const min = this.items[0];
        this.items[0] = this.items[this.size() - 1];
        this.items.pop();

        this.bubbleDown();
    }

    swap(a, b) {
        [this.items[a], this.items[b]] = [this.items[a], this.items[b]];
    }

    bubbleUp() {
        let index = this.size() - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.items[parentIndex] <= this.items[index]) break;

            this.swap(parentIndex, index);
            index = parentIndex;
        }
    }

    bubbleDown() {
        let index = 0;

        // 이 조건이 헷갈려
        while (index * 2 <= this.size() - 1) {
            let leftChild = index * 2 + 1;
            let rightChild = leftChild + 1;

            let smallChild =
                rightChild < this.size() && this.items[rightChild] < this.items[leftChild] ? rightChild : leftChild;

            if (this.items[index] <= this.items[smallChild]) {
                break;
            }

            this.swap(index, smallChild);
            index = smallChild;
        }
    }
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const N = Number(input[0]);

    const minHeap = new MinHeap();

    for (let i = 1; i <= N; i++) {
        input.split(' ').forEach((num) => {
            minHeap.push(Number(num));
        });
    }
};

console.log(solution());
