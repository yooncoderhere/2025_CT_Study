import sys
import heapq

n = int(sys.stdin.readline())
max_heap = []

for _ in range(n):
    number = int(sys.stdin.readline())

    if number > 0:
        heapq.heappush(max_heap, -number)

    else:
        if not max_heap:
            print(0)
        else:
            print(-heapq.heappop(max_heap))