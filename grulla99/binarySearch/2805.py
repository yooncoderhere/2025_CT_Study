import sys

input = sys.stdin.readline

n, m = map(int, input().split(" "))

arr = list(map(int, input().strip().split()))

start, end = 0, n

start, end = 0, max(arr)

result = 0
while start <= end:
    mid = (start + end) // 2

    # 주어진 높이에서 잘린 나무의 총 길이
    cut_wood = 0
    for tree in arr:
        if tree > mid:
            cut_wood += tree - mid

    if cut_wood >= m:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)
