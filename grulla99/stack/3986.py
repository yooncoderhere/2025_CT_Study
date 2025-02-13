import sys

input = sys.stdin.readline
n = int(input())
result = n

for _ in range(n):
    stack = []
    text = input().rstrip()

    for i in text:

        if stack and stack[-1] == i:
            stack.pop()
        else:
            stack.append(i)

    if stack:
        result -= 1

print(result)