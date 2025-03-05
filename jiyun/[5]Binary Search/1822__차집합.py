import sys

#input = sys.stdin.readline

#A_num , B_num = map(int,input().split())
#왜 더 오래 걸리지...?

A = set(map(int,input().split()))
B = set(map(int,input().split()))

print(len(A-B)) # 차집합의 길이 출력
print(*sorted(list(A-B))) # list - sorted

# 데이터 받을 때 주의 