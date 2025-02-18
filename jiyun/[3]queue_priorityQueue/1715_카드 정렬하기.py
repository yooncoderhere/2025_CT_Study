# 그리디 + 우선순위 큐

import sys
import heapq

input = sys.stdin.readline

#특정한 순서를 유지하면서 가장 작은 혹은 가장 큰 값을 조회
heap = [] # 우선순위큐

N = int(input().strip())

#카드 묶음을 입력 받아 힙에 삽입함
for _ in range(N):
    heapq.heappush(heap, int(input().strip()))
    
total_cost = 0 # 비교횟수 초기화

# 힙에 원소가 2개 이상일 때만 실행함 (1개면 비교할 필요 없음)
while len(heap) > 1:
    
    #가장 작은 두 카드 묶음을 꺼냄 - 비교 횟수를 최소화 하기 위해서는
    #현재 가장 작은 묶음들부터 합쳐야 한다
    first = heapq.heappop(heap)
    second = heapq.heappop(heap)
    
    cost = first + second
    total_cost += cost
    
    heapq.heappush(heap,cost)
    
print(total_cost)
    
    