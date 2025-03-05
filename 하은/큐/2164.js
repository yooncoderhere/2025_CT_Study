class Queue {
    items = [];
    front = 0;
    rear = 0;

    push(item) {
        this.items[this.rear++] = item;
    }

    pop() {
        if (!this.size()) {
            return null;
        }
        return this.items[this.front++];
    }

    printQueue() {
        console.log(this.items.slice(this.front, this.rear));
    }

    size() {
        return this.rear - this.front;
    }
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const input = fs.readFileSync(filePath, 'utf-8').trim();
    const N = Number(input);

    const queue = new Queue();

    for (let i = 1; i <= N; i++) {
        queue.push(i);
    }

    while (queue.size() > 1) {
        queue.pop();
        const top = queue.pop();
        queue.push(top);
    }
    return queue.pop();
};

console.log(solution());
