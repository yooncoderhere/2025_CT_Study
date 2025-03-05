# 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

# 배열에 정수 x (x ≠ 0)를 넣는다.
# 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
# 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 
# 그 값을 배열에서 제거한다.
# 프로그램은 처음에 비어있는 배열에서 시작하게 된다.

#연산의 개수

import sys
import heapq # 우선순위 큐
input = sys.stdin.readline

n = int(input()) # 연산의 개수
heap = []

for _ in range(n):
    x = int(input().strip())
    
    #x가 0이라면, 
    if x == 0:

        if heap:
            print(heapq.heappop(heap)[1]) # 원래 값 출력
        
        #배열이 비어 있는 경우 0 출력
        else:
            print(0)
            
    else: # 절대값,원래값 삽입
        heapq.heappush(heap, (abs(x),x)) 