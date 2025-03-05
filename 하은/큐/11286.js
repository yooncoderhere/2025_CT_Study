class CircularQueue {
    constructor(maxSize) {
        this.maxSize = maxSize;
        this.queue = [];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    enqueue(value) {
        if (this.isFull()) {
            console.log('Queue is full.');
            return;
        }
        this.queue[this.rear] = value;
        this.rear = (this.rear + 1) % this.maxSize;
        this.size += 1;
    }

    dequeue() {
        const value = this.queue[this.front];
        delete this.queue[this.front];
        this.front = (this.front + 1) % this.maxSize;
        this.size -= 1;
        return value;
    }

    isFull() {
        return this.size === this.maxSize;
    }

    peek() {
        return this.queue[this.front];
    }
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim().split('\n');
    const N = Number(input[0]);

    let resNum = 0;
    const res = [];

    for (let i = 1; i <= N; i++) {
        if (input[i]) {
            queue.enqueue(Number(input[i]));
        } else if (!queue.size) {
            res.push(Number(input[i]));
        } else {
        }
    }

    const queue = new CircularQueue();
};

console.log(solution());
