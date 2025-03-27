import sys
import bisect

input = sys.stdin.readline

n, m = map(int, input().split())

w = [input().strip() for _ in range(n)]
p = [input().strip() for _ in range(m)]

w.sort()
cnt = 0

for prefix in p:
    pos = bisect.bisect_left(w, prefix)
    if pos < len(w) and w[pos].startswith(prefix):
        cnt += 1

print(cnt)