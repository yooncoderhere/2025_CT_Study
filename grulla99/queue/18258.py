import sys

from collections import deque

input = sys.stdin.readline

n = int(input())

queue = deque()

for _ in range(n):

    m = input().split()

    if (m[0] == 'push'):
        queue.append(m[1])

    elif (m[0] == 'pop'):
        if (len(queue) == 0):
            print(-1)
        else:
            print(queue.popleft())

    elif (m[0] == 'size'):
        print(len(queue))

    elif (m[0] == 'empty'):
        if (len(queue) == 0):
            print(1)
        else:
            print(0)

    elif (m[0] == 'front'):
        if (len(queue) == 0):
            print(-1)
        else:
            print(queue[0])

    elif (m[0] == 'back'):
        if (len(queue) == 0):
            print(-1)
        else:
            print(queue[-1])

