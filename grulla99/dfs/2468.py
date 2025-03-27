import sys
sys.setrecursionlimit(10**6)

n = int(input())

g = [list(map(int, input().split())) for _ in range(n)]


# 안전지역 갯수가 최대가 되어야함.
def inRange(x, y):
    return 0 <= x < n and 0 <= y < n

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = 1

def dfs(x, y):
    visited[x][y] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if inRange(nx, ny) and not visited[nx][ny]:
            if not marking_g[nx][ny]:
                dfs(nx, ny)

max_height = max(max(row) for row in g)

for i in range(1, max_height + 1):
    marking_g = [[False] * n for _ in range(n)]

    for j in range(n):
        for k in range(n):
            if g[j][k] <= i and not marking_g[j][k]:
                marking_g[j][k] = True
    # 안전영역 갯수 세기
    visited = [[False] * n for _ in range(n)]
    cnt = 0

    for a in range(n):
        for b in range(n):
            if not marking_g[a][b] and not visited[a][b]:
                cnt += 1
                dfs(a, b)
                result = max(cnt, result)
print(g)
print(result)