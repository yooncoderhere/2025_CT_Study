import sys
import heapq

# heap 정렬 후 중간 값 비교 후 작은

n = int(input())
heap = []

for i in range(1, n+1):
    num = int(input())
    heap.append(num)
    heap.sort()

    if i == 1:
        print(heap[0])
    elif i % 2 == 0: # 짝수
        left = i // 2
        right = (i // 2) + 1

        print(min(heap[left-1], heap[right-1]))
    else:
        print(heap[i // 2])
