import sys

input = sys.stdin.readline

n, s = map(int, input().split())
num = list(map(int, input().split()))

start, end = 0, 0
sums = 0
result = 100001

while True:
    if s <= sums:
        result = min(result, end - start)
        sums -= num[start]
        start += 1
    else:
        if end == n:
            break
        sums += num[end]
        end += 1

if result == 100001:
    print(0)
else:
    print(result)

