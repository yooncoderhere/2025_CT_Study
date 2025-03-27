import copy
import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

input = sys.stdin.readline

n, m = map(int, input().split())

g = [list(map(int, input().rstrip().split())) for _ in range(n)]

def inRange(x, y):
    return 0 <= x < n and 0 <= y < m

def bfs():
    queue = deque()
    test_g = copy.deepcopy(g)

    for i in range(n):
        for j in range(m):
            if test_g[i][j] == 2:
                queue.append((i, j))

    while queue:
        current_x, current_y = queue.popleft()

        for i in range(4):
            nx = current_x + dx[i]
            ny = current_y + dy[i]

            if inRange(nx, ny):
                if test_g[nx][ny] == 0:
                    test_g[nx][ny] = 2
                    queue.append((nx, ny))

    global result
    cnt = 0

    for i in range(n):
        for j in range(m):
            if test_g[i][j] == 0:
                cnt += 1

    result = max(result, cnt)

def make_wall(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if g[i][j] == 0:
                g[i][j] = 1
                make_wall(cnt + 1)
                g[i][j] = 0

result = 0
make_wall(0)

print(result)