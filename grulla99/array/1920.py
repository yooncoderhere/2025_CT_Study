import sys

n = int(sys.stdin.readline())
arr1 = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))

arr1.sort()
for i in arr2:
    left = 0
    right = n-1
    flag = False
    while left <= right:
        mid = (left + right) // 2
        if arr1[mid] == i:
            flag = True
            break
        elif arr1[mid] < i:
            left = mid + 1
        else:
            right = mid - 1
    if flag:
        print(1, end=' ')
    else:
        print(0, end=' ')