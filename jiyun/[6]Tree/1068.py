#  트리 문제
import sys
# 기본 재귀 깊이는 1000이기 때문에 이를 늘려줘야함
sys.setrecursionlimit(10**6)

# 트리 구조의 경우 딕셔너리로 받음
#
def dfs(node):
    # 자식이 없는 경우
    if node not in tree or not tree[node]:
        global leaf_count
        leaf_count += 1
        return
    
    for child in tree[node]:
        if child != remove_node:
            dfs(child)

N = int(input())
graphs = list(map(int, input().split()))
remove_node = int(input())

root = -1
tree = {} # 트리 딕셔너리 형태로 저장

for child,parent in enumerate(graphs):
    if parent == -1:
        root = child # 루트 노드 저장?
    else:
        if parent not in tree:
            tree[parent] = [] # 딕셔너리를 배열처럼
        tree[parent].append(child)

if remove_node == root:
    print(0) # 리프 노드의 개수는 0
    exit()

# 삭제할 노드를 트리에서 제거 
for node in tree.values():
    if remove_node in node:
        node.remove(remove_node)

leaf_count = 0
dfs(root)
print(leaf_count)



