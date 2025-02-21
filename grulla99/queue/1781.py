import sys
import heapq

input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    dead, cup = map(int, input().split())
    arr.append((dead, cup))

arr.sort(key=lambda x: x[0])

heap = []

for dead, cup in arr:
    heapq.heappush(heap, cup)

    if len(heap) > dead:
        heapq.heappop(heap)

result = sum(heap)
print(result)
# 3
# 3 5
# 3 4
# 1 1
# 데드라인이 3인 경우 1 선택하고 3 두개 선택 가능한 경우의 수를 생각
# cnt 가 d보다 작을 때는 선택안해도됌