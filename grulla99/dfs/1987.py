from sys import stdin

R, C = map(int, stdin.readline().split())
board = [list(stdin.readline().rstrip()) for _ in range(R)]

def dfs(a, b):
    q = {(a, b, board[a][b])}
    r = 0

    while q:
        x, y, history = q.pop()
        r = max(r, len(history))
        if r == 26 : return 26
        for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            nx, ny = x + dx, y + dy
            if not (0<=nx<R and 0<=ny<C) or board[nx][ny] in history: continue
            q.add((nx, ny, history + board[nx][ny]))

    return r

print(dfs(0,0))