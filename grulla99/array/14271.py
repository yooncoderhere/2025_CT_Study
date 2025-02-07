import sys
from collections import defaultdict

n, m = map(int, sys.stdin.readline().split())

grid = [sys.stdin.readline().strip() for _ in range(n)]

k = int(sys.stdin.readline())

alive = []
for r in range(n):
    for c in range(m):
        if grid[r][c] == 'o':
            alive.append((r, c))

if not alive:
    print(0)
    sys.exit(0)

row = defaultdict(list)

for (r, c) in alive:
    for x in range(r - k, r + k + 1):
        d = abs(x - r)
        if d > k:
            continue
        delta = k - d
        left = c - delta
        right = c + delta
        row[x].append((left, right))

total = 0

for i in row:
    intervals = row[i]

    intervals.sort(key=lambda interval: interval[0])
    merged = []

    cur_start, cur_end = intervals[0]
    for s, e in intervals[1:]:
        if s <= cur_end + 1:
            if e > cur_end:
                cur_end = e
        else:
            merged.append((cur_start, cur_end))
            cur_start, cur_end = s, e
    merged.append((cur_start, cur_end))

    for s, e in merged:
        total += (e - s + 1)

print(total)