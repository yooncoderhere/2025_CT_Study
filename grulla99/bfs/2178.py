import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())

g = [list(map(int, input().rstrip())) for _ in range(n)]

# 지나야하는 최소 칸의 수
visited=[[False] * m for _ in range(n)]

def inRange(x, y):
    return 0 <= x < n and 0 <= y < m

def bfs(x, y):
    visited[x][y] = True
    queue = deque([(x, y, 1)])
    # 해당 큐가 진행하는 거리 dist 추가

    while queue:
        current_x, current_y, dist = queue.popleft()

        if current_x == n-1 and current_y == m-1:
            return dist

        for i in range(4):
            nx = current_x + dx[i]
            ny = current_y + dy[i]

            if inRange(nx, ny) and not visited[nx][ny]:
                if g[nx][ny] == 1:
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist + 1))

    return -1

print(bfs(0, 0))