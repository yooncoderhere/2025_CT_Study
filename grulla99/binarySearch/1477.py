import sys, math, heapq

input = sys.stdin.readline

n, m, l = map(int, input().split())

if n:
    snack_town = list(map(int, input().split()))
else:
    snack_town = []

snack_town.sort()
gaps = []
if snack_town:
    gaps.append(snack_town[0])
    for i in range(1, len(snack_town)):
        gaps.append(snack_town[i]-snack_town[i-1])
    gaps.append(l - snack_town[-1])
else:
    gaps.append(l)

heap = []

for gap in gaps:
    heapq.heappush(heap, (-gap, gap, 0))

for _ in range(m):
    current, origin, cnt = heapq.heappop(heap)
    new_cnt = cnt + 1

    new_max = math.ceil(origin / (new_cnt + 1))
    heapq.heappush(heap, (-new_max, origin, new_cnt))

result = -heap[0][0]
print(result)