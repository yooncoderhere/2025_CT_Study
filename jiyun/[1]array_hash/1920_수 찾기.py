import sys

input = sys.stdin.read
data = input().split()

# 자연수 N
num_cards = int(data[0])

# 정수 받기
card_set = set(map(int, data[1:num_cards+1]))

# 찾을 숫자의 개수
num_queries = int(data[num_cards+1])

query_numbers = map(int, data[num_cards+2:])

# 각 숫자가 카드 목록에 존재하는지 확인
results = [1 if number in card_set else 0 for number in query_numbers]

# 결과 출력 (한 줄씩 출력)
sys.stdout.write("\n".join(map(str, results)) + "\n")