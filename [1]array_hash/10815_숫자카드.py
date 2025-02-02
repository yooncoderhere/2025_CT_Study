import sys
input = sys.stdin.read

# 입력 받기
data = input().split()
N = int(data[0])

cards = set(map(int, data[1:N+1]))  # 집합으로 변환

# 찾을 숫자의 개수 M
M = int(data[N+1])
targets = map(int, data[N+2:])  # 리스트 슬라이싱

# 존재 여부 확인
result = [1 if num in cards else 0 for num in targets]

# 출력
print(" ".join(map(str, result)))