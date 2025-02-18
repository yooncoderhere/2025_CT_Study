#N개의 카드 1-N개의 번호를 가짐

#1번 카드가 제일 위해
#N번 카드가 제일 아래에 위치함
#제일 위에 있는 카드를 바닥에 버리고 그 다음 제일 위에 있는 카드를
#제일 아래에 있는 카드 밑으로 옮긴다
#카드가 한 장 남을 때까지 반복

import sys
from collections import deque

input =sys.stdin.readline

N = int(input().strip()) # 카드의 개수

#큐 초기화 1~N
queue = deque(range(1,N+1))

while len(queue) > 1:
    queue.popleft() # 맨 앞의 카드를 버림
    queue.append(queue.popleft()) # 맨 앞의 카드를 맨 뒤로 이동함
    
print(queue[0]) # 마지막 카드를 출력함