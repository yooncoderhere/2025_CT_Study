import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

tree = {}

n, m = map(int, input().split())

tree_val = list(map(int, input().split()))

for i in range(1, n + 1):
    tree[i] = []

for i in range(1, len(tree_val) + 1):
    if tree_val[i-1] != -1:
        tree[tree_val[i-1]].append(i)

# 칭찬 시작
compliment = [0] * (n + 1)

for i in range(m):
    idx, w = map(int, input().split())
    compliment[idx] += w

def dfs(x):
    for child in tree[x]:
        compliment[child] += compliment[x]
        dfs(child)

dfs(1)

print(" ".join(map(str, compliment[1:])))

