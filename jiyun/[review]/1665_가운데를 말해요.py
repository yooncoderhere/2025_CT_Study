import sys
import heapq

#최소 힙 + 최대 힙을 통해서 중간 값을 유지함

input = sys.stdin.read
data = input().split()
N = int(data[0])

left_heap = []  # 최대 힙 (중앙값 이하)
right_heap = [] # 최소 힙 (중앙값 이상)
result = []

for i in range(1, N+1):
    num = int(data[i])

    # 1. 최대 힙(left_heap)에 넣기 (음수로 저장하여 최대 힙처럼 사용)
    heapq.heappush(left_heap, -num)

    # 2. 최대 힙의 최대값을 최소 힙으로 이동 (중앙값을 유지하기 위함)
    if left_heap and right_heap and (-left_heap[0] > right_heap[0]):
        heapq.heappush(right_heap, -heapq.heappop(left_heap))

    # 3. 균형 유지 (left_heap 크기가 right_heap보다 크거나 같도록)
    if len(left_heap) > len(right_heap) + 1:
        heapq.heappush(right_heap, -heapq.heappop(left_heap))
    elif len(left_heap) < len(right_heap):
        heapq.heappush(left_heap, -heapq.heappop(right_heap))

    # 4. 중앙값 출력 (최대 힙의 루트가 항상 중앙값)
    result.append(str(-left_heap[0]))

sys.stdout.write("\n".join(result) + "\n")
