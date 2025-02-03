import sys
from collections import deque

def in_range(nx, ny):
    return 0 <= nx < n and 0 <= ny < n

def bfs(x, y):
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny) and not visited[nx][ny] and graph[nx][ny] == graph[x][y]:
                q.append((nx, ny))
                visited[nx][ny] = True


dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

cnt = 0

n = int(input())

graph = []

for i in range(n):
    graph.append(list(sys.stdin.readline().strip()))

visited = [[False] * n for _ in range(n)]
q = deque()
cnt1 = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            cnt1 += 1

for i in range(n):
    for j in range(n):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

visited = [[False] * n for _ in range(n)]
cnt2 = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i,j)
            cnt2 += 1

print (cnt1, cnt2)