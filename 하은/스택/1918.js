const stack = [];
let top = -1;

function isEmpty() {
    return top === -1;
}
function push(item) {
    stack[++top] = item;
    return;
}

function pop() {
    if (!isEmpty()) {
        return stack[top--];
    }
    return false;
}

function priority(operator) {
    switch (operator) {
        case '+':
        case '-':
            return '+-*/'.includes(stack[top]);
        case '*':
        case '/':
            return '*/'.includes(stack[top]);
        default:
            return false;
    }
}

function printStack() {
    return isEmpty() ? [] : stack.slice(0, top + 1).join(' ');
}

const solution = () => {
    const fs = require('fs');
    const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
    const infix = fs.readFileSync(filePath, 'utf-8').trim().split('\n')[0];
    const postfix = [];

    for (let c of infix) {
        //1. 피연산자인 경우에는, postfix에 넣기
        if (!'+-*/()'.includes(c)) {
            postfix.push(c);

            //2. 연산자인 경우, 우선순위를 체크해서 pop해줘야 함
        } else {
            if (c === '(') {
                //2-1. '('면 그냥 넣기
                push(c);
            } else if (c === ')') {
                //2-2. ')'면 '('가 pop될 때까지 연산자를 pop을 해야 함.
                while (!isEmpty() && stack[top] !== '(') {
                    postfix.push(pop());
                }
                pop();
            } else {
                //2-3. +-*/연산자인 경우 해당 연산자보다 stack top 연산자의 우선순위가 같거나 높다면 pop해야 함
                while (priority(c)) {
                    postfix.push(pop());
                }
                // 우선순위가 높거나 같은 연산자를 다 없앤 후 push
                push(c);
            }
        }
    }

    //3. 스택에 남아있는 거 다 빼기
    while (!isEmpty()) {
        postfix.push(pop());
    }
    return postfix.join('');
};

console.log(solution());
