import sys

input = sys.stdin.readline

n = int(input())
tree = {}

for key in range(n):
    tree[key] = []

tree_value = list(map(int, input().split()))

for val in range(len(tree_value)):
    if tree_value[val] == -1:
        continue
    else:
        tree[val].append(tree_value[val])

m = int(input()) # 삭제 노드

def recursive_del(node):
    for key, val in list(tree.items()):
        if node in val:
            recursive_del(key)
            del tree[key]

if m in tree:
    recursive_del(m)
    del tree[m]

cnt = 0

ref = set()
for key, val in tree.items():
    for child in val:
        ref.add(child)

for key in tree.keys():
    if key not in ref:
        cnt += 1

print(cnt)

# Tree 구현 - 완
# 노드 삭제 구현 자식 노드까지 드랍 - 완
# 리프노드를 찾는 로직

# 틀린점 - tree 삭제 시 재귀적으로 삭제를 일으켜야하는데 그냥 삭제했음.