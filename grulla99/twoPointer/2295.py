import sys

input = sys.stdin.readline

n = int(input())
u = set()
result = []

for i in range(n):
    u.add(int(input()))

sum = set()
for i in u:
    for j in u:
        sum.add(i+j)

for i in u:
    for j in u:
        if (i-j) in sum:
            result.append(i)

result.sort()
print(result[-1])