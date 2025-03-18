# 간선에 가중치와 방향성이 없는 임의의 루트 있는 트리가 주어졌을 때,ㅡ
# 정점 U를 루트로 하는 서브트리에 속한 노드의 수를 출력함

# N-1줄에 걸쳐 간선의 정보를 받음
# 간선이 트리에 속함

# 동일한 계산이 반복 되지 않게 , DP 사용
# DFS -> 임의의 노드에서 다음 분기로 넘어 가기 전에 해당 분기를 완벽하게 탐색

# DP + DFS

import sys
sys.setrecursionlimit(10**6) # 재귀함수

input = sys.stdin.readline

def dfs(node,parent):
    sub_trees[node] = 1 # 

    for child in trees[node]:
        if child != parent: # 방문하지 않은 노드만 탐색
            dfs(child,node)
            sub_trees[node] += sub_trees[child] 


# 트리의 정점 수 N
# 루트의 번호 R
# 쿼리의 수 Q
N, R, Q = map(int,input().split()) # 
trees = {i : [] for i in range(1, N+1)} # 트리 생성
sub_trees = [0] *(N+1) #DP

#트리 입력 받는 부분
# for _ in range(간선의 개수)
for _ in range(N-1):
    a,b = map(int,input().split())
    trees[a].append(b)
    trees[b].append(a)

dfs(R,-1) # 루트 노드에서 시작

#
for _ in range(Q):
    U = int(input())
    print(sub_trees[U])