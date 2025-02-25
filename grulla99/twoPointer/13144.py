import sys

input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))

start = 0
end = 0

result = 0

visited = [False] * 100001

while start <= end and end < n:
    if not visited[arr[end]]:
        visited[arr[end]] = True
        end += 1
        result += end - start
    else:
        while visited[arr[end]]:
            visited[arr[start]] = False
            start += 1

print(result)