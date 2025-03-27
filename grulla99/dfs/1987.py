import sys
sys.setrecursionlimit(10**6)

r, c = map(int, input().split())

g = [list(input().strip()) for _ in range(r)]

def inRange(x, y):
    return 0 <= x < r and 0 <= y < c

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

max_cnt = 0

alpa = set()

def dfs(x, y, alpa, cnt):
    global max_cnt
    max_cnt = max(max_cnt, cnt)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if inRange(nx, ny):
            if g[nx][ny] not in alpa:
                alpa.add(g[nx][ny])
                dfs(nx, ny, alpa, cnt + 1)
                alpa.remove(g[nx][ny]) # 스택이니까

dfs(0, 0, {g[0][0]}, 1)

print(max_cnt)