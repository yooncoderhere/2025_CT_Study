import sys

input = sys.stdin.read
data = input().split("\n")

# 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M
N, M = map(int, data[0].split())

# 듣도 못한 사람 목록 (집합으로 저장 → 탐색 O(1))
not_heard = set(data[1:N+1])

# 듣보잡 명단을 저장할 리스트
not_heard_seen = []

# 보도 못한 사람 확인 (듣도 못한 사람과 겹치는지 확인)
for name in data[N+1:N+1+M]:
    if name in not_heard:  # 교집합 찾기
        not_heard_seen.append(name)

# 사전순 정렬
not_heard_seen.sort()

# 결과 출력
sys.stdout.write(f"{len(not_heard_seen)}\n" + "\n".join(not_heard_seen) + "\n")
