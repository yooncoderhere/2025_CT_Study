import sys

n , m = map(int,sys.stdin.readline().split()) # 집합 a,b의 원소 개수
a = set(map(int, sys.stdin.readline().split()))
b = set(map(int,sys.stdin.readline().split()))

print(len(a^b)) # symmetirc_difference() 대칭 차집합 