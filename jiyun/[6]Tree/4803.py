#그래프에서 트리의 개수를 찾는 문제

#트리는 사이클이 없는 연결 그래프
#양방향 그래프

#연결 요소 찾기
#그래프에서 DFS 혹은 BFS를 사용하여 연결된 노드 집합 찾기

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(node):
    global node_count , edge_count

    #현재 노드를 방문 처리
    visited[node] = True
    node_count += 1
#
#방문하지 않은 노드를 방문 
    for neighbor in graph[node]:
        edge_count += 1
        if not visited[neighbor]:
            dfs(neighbor) # 재귀함수 호출

case_num =0

while True:
    case_num += 1

    # 정점의 개수 n , 간선의 개수 m
    n, m = map(int, input().split())

    if n == 0 and m == 0:
        break

    graph = {i: [] for i in range(1,n+1)} # 그래프 생성
    visited = [False] * (n+1) # 정점의 개수

#그래프 입력 받기
    for _ in range(m):
        a,b = map(int, input().split())
        graph[a].append(b)
        #딕셔너리 접근
        graph[b].append(a)
    tree_count = 0

#노드 탐색
    for i in range(1,n+1):
        if not visited[i]:
            node_count , edge_count = 0, 0
            dfs(i)

#트리 판별 / 간선 개수 = (노드 개수 -1)
            if edge_count // 2 == node_count -1:
                tree_count +=1

#트리 판별
    # 출력 포맷 맞추기
    if tree_count == 0:
        print(f"Case {case_num}: No trees.")
    elif tree_count == 1:
        print(f"Case {case_num}: There is one tree.")
    else:
        print(f"Case {case_num}: A forest of {tree_count} trees.")

