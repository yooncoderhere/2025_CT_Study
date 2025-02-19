import sys
from collections import deque

n = int(sys.stdin.readline().strip())
queue = deque()

for i in range(n):
    queue.append(i+1)

while len(queue) > 1:
    queue.popleft()
    change = queue[0]
    queue.popleft()
    queue.append(change)

print(queue[0])