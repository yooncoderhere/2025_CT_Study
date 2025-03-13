import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
limit = int(input())
start = 0
end = max(arr)

while start <= end:
    mid = (start+end) // 2
    total = 0

    for i in arr:
        if i > mid:
            total += mid
        else:
            total += i

    if total <= limit:
        start = mid + 1
    else:
        end = mid - 1

print(end)