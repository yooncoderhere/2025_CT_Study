import sys

n, m = map(int, sys.stdin.readline().split())

arr1 = []
arr2 = []
cnt = 0

for i in range(n):
    arr1.append(sys.stdin.readline().strip())

for i in range(m):
    arr2.append(sys.stdin.readline().strip())

arr1.sort()

for i in arr2:
    left = 0
    right = n - 1
    flag = False
    while left <= right:
        mid = (left + right) // 2
        if arr1[mid] == i:
            flag = True
            cnt += 1
            break
        elif arr1[mid] < i:
            left = mid + 1
        else:
            right = mid - 1

print(cnt)