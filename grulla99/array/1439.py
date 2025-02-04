import sys

n = sys.stdin.readline()

num = n[0]
zero = 0
one = 0

for i in range(1, len(n)):
    if num != n[i]:
        if num == '0':
            zero += 1
        else:
            one += 1
        num = n[i]

print(min(zero, one))