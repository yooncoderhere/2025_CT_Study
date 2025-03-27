import sys
input = sys.stdin.readline

n, m = map(int, input().split())

tree = {}
cnt = 0

def connect_node(x, y):
    tree[x].append(y)
    tree[y].append(x)

def deconnect_node(x, y):
    tree[x].remove(y)
    tree[y].remove(x)

for key in range(1, n + 1):
    tree[key] = []

for _ in range(m):
    val1, val2 = map(int, input().split())
    connect_node(val1, val2)

visited_nodes = [False] * (n + 1)

def dfs(start):
    stack = [start]
    visited_nodes[start] = True

    while stack:
        cur = stack.pop()
        for nxt in tree[cur]:
            if not visited_nodes[nxt]:
                visited_nodes[nxt] = True
                stack.append(nxt)

components = 0
for i in range(1, n + 1):
    if not visited_nodes[i]:
        components += 1
        dfs(i)

r = m - (n - components)
cnt = r +  (components - 1)

print(cnt)

# (m -(n-k)) + (k-1)