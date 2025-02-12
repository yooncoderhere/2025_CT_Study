import sys

input = sys.stdin.readline

n = int(input())

stack = []
result = []
flag = True
now = 1

for i in range(n):
    num = int(input())

    while now <= num:
        stack.append(now)
        result.append('+')
        now += 1

    if stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        flag = False

if not flag:
    print('NO')
else:
    for i in result:
        print(i)