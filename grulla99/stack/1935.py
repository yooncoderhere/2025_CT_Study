import sys

input = sys.stdin.readline

n = int(input())
exp = input().strip()

stack = []
real = []

for i in range(n):
    real.append(int(input()))

for i in exp:
    if i.isalpha():
        stack.append(real[ord(i)-65])

    else:
        a = stack.pop()
        result = stack.pop()

        if i == '+':
            result += a

        elif i == '-':
            result -= a

        elif i == '*':
            result *= a

        elif i == '/':
            result /= a

        stack.append(result)

print('%.2f' %stack[-1])