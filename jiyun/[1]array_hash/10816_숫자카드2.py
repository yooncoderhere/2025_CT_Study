import sys
from collections import Counter

n = int(sys.stdin.readline().strip())
cards = list(map(int,sys.stdin.readline().split()))

m = int(sys.stdin.readline().strip())
targets = list(map(int,sys.stdin.readline().split()))

# target 숫자 카드를 몇 개 가지고 있는지
# 숫자 카드 개수를 dict 형태로 저장 후
card_count = Counter(cards)
#print(card_count)

#상근이가 가진 숫자 카드의 개수 리스트에 넣고
result = [str(card_count[target]) for target in targets] 

#출력
print(" ".join(result))