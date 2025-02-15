import sys

input = sys.stdin.readline

n = int(input())

arr1 = [*map(int, input().split())]
arr2 = [*map(int, input().split())]

for i in range(n):
    arr1[i] -= arr2[i]

cnt = 0
for i in range(n):
    if arr1[i] == 0:
        continue
    if arr1[i] > 0:
        x = 1
    else:
        x = -1
    while arr1[i] != 0:
        cnt += 1
        for j in range(1, n):
            if arr1[j] * x <= 0:
                break
            arr1[j] -= x
print(cnt)