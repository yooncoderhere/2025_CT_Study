# DFS 문제

import sys
sys.setrecursionlimit(10000) # 재귀함수 한도

n = int(sys.stdin.readline.strip())
graph = [list(sys.stdin.readline.strip() for _ in range(n))]

visited = [[False]* n for _ in range(n)]

#상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs(x,y,color,is_colorblind):
    visited[x][y] = True
    for i in range(4):
        nx,ny = x+dx[i], y+dy[i]
        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            if is_colorblind: # 적록 색약 모드
                if (graph[nx][ny] == color) or (color in "RG" and graph[nx][ny] in "RG"):
                    dfs(nx,ny,color,is_colorblind)
                
            else: # 일반
                if graph[nx][ny] == color:
                    dfs(nx,ny,color,is_colorblind)

#일반
count_normal = 0
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j, graph[i][j], is_colorblind=False)
            count_normal += 1  # 새로운 구역 발견

# 적록색약인 경우
count_colorblind = 0
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j, graph[i][j], is_colorblind=True)
            count_colorblind += 1  # 새로운 구역 발견

# 결과 출력
print(count_normal, count_colorblind)