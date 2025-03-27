import sys
from collections import deque
# 이것도 다리 건설 def 만들어서 하면될 듯 ㅋ;
#
n = int(input())

g = [list(map(int, input().rstrip().split())) for _ in range(n)]

visited = [[0] * n for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

global num
num = 0

def inRange(x, y):
    return 0 <= x < n and 0 <= y < n

def find_island(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        current_x, current_y = queue.popleft()

        for i in range(4):
            nx = current_x + dx[i]
            ny = current_y + dy[i]

            if inRange(nx, ny) and not visited[nx][ny]:
                if g[nx][ny] == 1:
                    visited[nx][ny] = num
                    queue.append((nx, ny))

# 섬 마킹
for i in range(n):
    for j in range(n):
        if g[i][j] == 1 and visited[i][j] == 0:
            num += 1
            visited[i][j] = num
            find_island(i, j)

def make_bridge(i, j):
    current_num = visited[i][j]
    queue = deque()
    queue.append((i, j, 0))
    bridge_visited = [[False] * n for _ in range(n)]
    bridge_visited[i][j] = True

    while queue:
        current_x, current_y, dist = queue.popleft()

        for i in range(4):
            nx = current_x + dx[i]
            ny = current_y + dy[i]

            if inRange(nx, ny) and not bridge_visited[nx][ny]:
                if visited[nx][ny] != 0 and visited[nx][ny] != current_num:
                    return dist
                if visited[nx][ny] == 0:
                    bridge_visited[nx][ny] = True
                    queue.append((nx, ny, dist + 1))
    return float('inf')

result = float('inf')

# 외곽확인
for i in range(n):
    for j in range(n):
        if visited[i][j] != 0:
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if inRange(nx, ny) and visited[nx][ny] == 0:
                    result = min(result, make_bridge(i, j))
                    break
print(result)

    # 섬을 먼저 찾아! 그리고 그 섬은 전부 마킹해놔 넘버로
    # 그리고 그 섬의 외곽(외각을 어떻게 알지?? 외각은 해당 타일 주변에 0이 있으면 외각)
    # 섬의 외각 부터 다리 건설 시작(어떻게 건설?? dx, dy 로 하나씩 건설)
    # 건설 도중 1을 만나면 중단 후 다리 개수 카운팅
    # 작은 다리를 result = min(result, cnt) 구하기
    # 이짓을 1번섬 -> 2, 3 번 섬, 2번섬 -> 3번섬 이렇게 해야함.
