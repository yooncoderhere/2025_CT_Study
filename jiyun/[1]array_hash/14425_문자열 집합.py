import sys

#입력 받기
n,m = map(int,sys.stdin.readline().split())

# 집합 s 문자열을 저장
s_set = set(sys.stdin.readline().strip() for _ in range(n))

# m 개의 문장 중 집합 s에 해당하는 것이 있으면,
count = sum(1 for _ in range(m) if sys.stdin.readline().strip() in s_set)

print(count)