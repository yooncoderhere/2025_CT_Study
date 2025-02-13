import sys
from collections import deque
# 오른쪽에 있는 수 중에 현재 값보다 큰 수 중 가장 왼쪽에 있는 수 = 오큰 수

input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))
NGE = [-1]*n
stack = deque()

for i in range(n):
    while stack and (stack[-1][0] < arr[i]):
        tmp, idx = stack.pop()
        NGE[idx] = arr[i]
    stack.append([arr[i], i])

print(*NGE)