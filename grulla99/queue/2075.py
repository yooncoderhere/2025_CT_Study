import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []

for _ in range(n):
    num = map(int, input().split())
    for i in num:
        if len(heap) < n:
            heapq.heappush(heap, i)

        else:
            if heap[0] < i:
                heapq.heappop(heap)
                heapq.heappush(heap, i)

print(heap[0])

# 메모리 초과

# import sys
# import heapq
#
# input = sys.stdin.readline
#
# n = int(input())
# matrix = [list(map(int, input().split())) for _ in range(n)]
#
# def find_num(matrix, n):
#     heap = []
#     for i in range(n):
#         heapq.heappush(heap, (-matrix[n-1][i], n-1, i))
#
#     cnt = 0
#     result = 0
#
#     while cnt < n:
#         val, row, col = heapq.heappop(heap)
#         result = -val
#         cnt += 1
#         if row > 0:
#             heapq.heappush(heap, (-matrix[row-1][col], row-1, col))
#     return result
#
# print(find_num(matrix, n))