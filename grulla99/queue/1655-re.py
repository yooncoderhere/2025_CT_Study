import sys
import heapq

input = sys.stdin.readline

n = int(input())

leftheap = []
rightheap = []

for i in range(n):
    num = int(input())

    if len(leftheap) == len(rightheap):
        heapq.heappush(leftheap, -num)
    else:
        heapq.heappush(rightheap, num)

    if rightheap and rightheap[0] < -leftheap[0]:
        leftvalue = heapq.heappop(leftheap)
        rightvalue = heapq.heappop(rightheap)

        heapq.heappush(leftheap, -rightvalue)
        heapq.heappush(rightheap, -leftvalue)

    print(-leftheap[0])