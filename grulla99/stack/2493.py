import sys

input = sys.stdin.readline

n = int(input())
top = list(map(int, input().split()))
result = [0]

stack = []
stack.append([1, top[0]])

for i in range(1, n):
    while stack:
        if stack[-1][1] >= top[i]:
            result.append(stack[-1][0])
            stack.append([i + 1, top[i]])
            break
        else:
            stack.pop()
    if not stack:
        result.append(0)
        stack.append([i + 1, top[i]])

print(*result, end=" ")
