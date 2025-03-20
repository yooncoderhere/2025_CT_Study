# 1. bfs 로 상하, 좌우로 연결되어 있는 집 탐색
# 1-1. 탐색하면서 단지별로 이어져 있는 것에 개수를 측정
# 1-2. 마킹 필수
# 2. 단지 개수 및 오름차순 출력

import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

map = [list(map(int, input().rstrip())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[False] * n for _ in range(n)]
result = []
num = 0

def inRange(x, y):
    return 0 <= x < n and 0 <= y < n

def bfs(x, y):
    cnt = 1
    visited[x][y] = True
    queue = deque([(x, y)])

    while queue:
        current_x, current_y = queue.popleft()

        for i in range(4):
            nx = current_x + dx[i]
            ny = current_y + dy[i]

            if inRange(nx, ny) and not visited[nx][ny]:
                if map[nx][ny] == 1:
                    cnt += 1
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    return cnt

for i in range(n):
    for j in range(n):
        if map[i][j] == 1 and not visited[i][j]:
            num += 1
            result.append(bfs(i, j))

result.sort()

print(num)
for i in range(len(result)):
    print(result[i])