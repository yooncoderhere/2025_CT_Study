import sys

n = int(sys.stdin.readline())
arr1 = sorted(list(map(int, sys.stdin.readline().split())))

m = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))

dic = {}
for i in arr1:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

for i in arr2:
    left = 0
    right = n-1
    while left <= right:
        mid = (left + right) // 2
        if arr1[mid] == i:
            print(dic[i], end=' ')
            break
        elif arr1[mid] < i:
            left = mid + 1
        else:
            right = mid - 1
    else:
        print(0, end=' ')