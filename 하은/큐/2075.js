class MinHeap {
    constructor(maxSize) {
        this.items = [];
        this.maxSize = maxSize;
    }
    size() {
        return this.items.length;
    }

    insert(item) {
        this.items.push(item);
        this.bubbleUp();

        if (this.items.length > this.maxSize) {
            this.remove();
        }
    }

    remove() {
        if (!this.size()) return null;

        const min = this.items[0];
        this.items[0] = this.items[this.size() - 1];
        this.items.pop();

        this.bubbleDown();
        return min;
    }

    swap(a, b) {
        [this.items[a], this.items[b]] = [this.items[b], this.items[a]];
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
        while (index * 2 < this.size() - 1) {
            let leftChild = index * 2 + 1;
            let rightChild = leftChild + 1;

            let minChild =
                rightChild < this.size() && this.items[rightChild] < this.items[leftChild] ? rightChild : leftChild;

            if (this.items[index] <= this.items[minChild]) {
                break;
            }

            this.swap(index, minChild);
            index = minChild;
        }
    }
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const N = Number(input[0]);

    const minHeap = new MinHeap(N);

    for (let i = N; i >= 1; i--) {
        input[i].split(' ').forEach((num) => {
            minHeap.insert(Number(num));
        });
    }

    return minHeap.items[0];
};

console.log(solution());
