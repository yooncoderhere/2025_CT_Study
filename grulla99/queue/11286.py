import sys
import heapq
from collections import deque

input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    x = int(input())

    if x != 0:
        heapq.heappush(arr, (abs(x), x))
    else:
        if arr:
            arr_abs, arr_val = heapq.heappop(arr)
            print(arr_val)
        else:
            print(0)