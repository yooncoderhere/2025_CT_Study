import sys

paper = [[0] * 100 for _ in range(100)]
#도화지 생성 100 x 100

n = int(sys.stdin.readline())

for _ in range(n): # 색종이 개수
    x,y = map(int, sys.stdin.readline().split())
    for i in range(x,x+10): # 가로 10칸
        for j in range(y,y+10): # 세로 10칸
            paper[i][j] = 1 # 색종이를 붙인 부분

result = sum(sum(row) for row in paper)
print(result)
