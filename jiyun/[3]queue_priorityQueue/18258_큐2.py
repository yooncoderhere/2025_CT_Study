import sys
from collections import deque

input = sys.stdin.readline
q = deque() # 큐 라이브러리
n = int(input().strip()) # 명령의 수

for _ in range(n):
    command = input().strip().split()
    #큐에 요소를 추가
    if command[0] =="push":
        q.append(command[1])
    #큐의 가장 앞에 있는 정수를 뺌
    elif command[0] == "pop":
        print(q.popleft() if q else -1)    
    
    #큐의 개수
    elif command[0] == "size":
        print(len(q))
    #큐가 비어있는 경우
    elif command[0] == "empty":
        print(1 if not q else 0)
    elif command[0] == "front":
        print(q[0] if q else -1)
    elif command[0] == "back":
        print(q[-1] if q else -1)
        