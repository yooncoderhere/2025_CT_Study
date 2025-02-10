import sys

input = sys.stdin.readline

def solution():
    N, M = map(int, input().split()) #행,열
    visited = [[False]*3050 for _ in range(3050)] # 무한 grid
    stack = [] # 살아있는 칸 관리 리스트
    res = 0 # 살아있는 칸의 개수를 저장
    
    for r in range(1500, 1500+N): # 입력 그리드
        state = input()
        for c in range(M):
            if state[c] == 'o': # 살아있는 칸을 찾고 stack에 저장
                stack.append((r, c+1500))
                visited[r][c+1500] = True
                res += 1 # 살아있는 칸 개수 증가
    delta = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 상우하좌
    K = int(input()) # 초 단위로 확장할 횟수
    for _ in range(K): #k초 동안 확장
        if not stack:
            break
        _stack = [] 
        while stack:
            r, c = stack.pop() # 
            for dr, dc in delta:
                if visited[r+dr][c+dc]:
                    continue
                _stack.append((r+dr, c+dc))
                visited[r+dr][c+dc] = True
                res += 1
        stack = _stack
    print(res)

solution()