import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []

for i in range(n):
    heapq.heappush(heap, int(input()))

result = 0

while len(heap) > 1:
    a = heapq.heappop(heap)
    b = heapq.heappop(heap)
    cnt = a + b
    result += cnt
    heapq.heappush(heap, cnt)
print(result)