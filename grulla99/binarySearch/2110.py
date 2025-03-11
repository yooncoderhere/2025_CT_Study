import sys
input = sys.stdin.readline

n, c = map(int,input().split())
arr = [int(input()) for _ in range(n)]
arr.sort()

start = 1
end = arr[-1] - arr[0]
result = 0

while start <= end :
  cur = arr[0]
  cnt = 1
  mid = (start+end) // 2

  for i in range(1, n) :
    if arr[i] - cur >= mid :
      cnt += 1
      cur = arr[i]
  if cnt >= c :
    if result < mid :
      result = mid
    start = mid + 1
  else :
    end = mid - 1

print(result)