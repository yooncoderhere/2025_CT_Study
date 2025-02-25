import sys

input = sys.stdin.readline

n, d, k, c = map(int, input().split())
# n 접시 수, d 초밥 가지 수, k 연속해서 먹는 접시 수, c 쿠폰 번호
arr = []
result = 0

for _ in range(n):
    arr.append(int(input()))

for i in range(n):
    if ( i + k ) < n:
        temp = len(set(arr[i:i+k] + [c]))
    else:
        temp = len(set(arr[i:n] + arr[:(i+k)%n] + [c]))
    print(temp)
    result = max(result, temp)

print(result)
