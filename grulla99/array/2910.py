import sys

n, c  = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

freq = {}
first_idx = {}

for idx, num in enumerate(arr):
    if num in freq:
        freq[num] += 1
    else:
        freq[num] = 1
        first_idx[num] = idx

sorted_nums = sorted(arr, key=lambda num: (-freq[num], first_idx[num]))

print(" ".join(map(str, sorted_nums)))