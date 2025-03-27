import sys

n = int(input())

g = [list(map(int, input().rstrip())) for _ in range(n)]

visited = [[False] * n for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cnt = 0 # 총 단지 수
result = [] # 오름차순 정렬 할 단지

def inRange(x, y):
    return 0 <= x < n and 0 <= y < n

def dfs(x, y):
    visited[x][y] = True
    c = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if inRange(nx, ny) and g[nx][ny] != 0:
            if not visited[nx][ny]:
                c += dfs(nx, ny)

    return c

for i in range(n):
    for j in range(n):
        if g[i][j] != 0:
            if not visited[i][j]:
                cnt += 1
                count = 0
                result.append(dfs(i, j))

print(cnt)

result.sort()
for i in range(len(result)):
    print(result[i])