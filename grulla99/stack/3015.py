import sys

input = sys.stdin.readline

n = int(input())
arr = []
result = 0
stack = [] # (키, 연속 횟수)

for i in range(n):
    arr.append(int(input()))

for height in arr:
    cnt = 1

    while stack and stack[-1][0] < height:
        result += stack[-1][1]
        stack.pop()

    if stack and stack[-1][0] == height:
        same_cnt = stack.pop()[1]
        result += same_cnt

        if stack:
            result += 1
        cnt = same_cnt + 1
        stack.append((height, cnt))

    else:
        if stack:
            result += 1
        stack.append((height, 1))

print(result)