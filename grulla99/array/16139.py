import sys

s = sys.stdin.readline().rstrip()
q = int(sys.stdin.readline().rstrip())
question = []

for _ in range(q):
    a, l, r = sys.stdin.readline().rstrip().split()
    t = s[int(l) : int(r) + 1]
    cnt = 0

    for i in t:
        if i == a:
            cnt += 1

    print(cnt)