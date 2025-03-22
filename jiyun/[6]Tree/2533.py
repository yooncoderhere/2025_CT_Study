# 그래프 문제
# 만약 사이클이 없다면 트리 구조라고 볼 수 있음


# 사람들은 얼리 아답터이거나 아님(두 가지 상태로만 존재함)
# 얼리 아답터가 아닌 사람들은 자신들의 모든 친구가 얼리 아답터
# 일 때만 이 아이디어를 받아들임


# 친구 관계 트리가 주어졌을 때,
# 모든 개인이 새로운 아이디어를 수용하기 위해 필요한
# 최소 얼리 어답터의 개수

# DFS 문제가 아닐까? -> DP + DFS

import sys

sys.setrecursionlimit(10**6)
#재귀 함수 제한 해제
input = sys.stdin.readline

N = int(input())
# 노드 개수
graph = [[] for _ in range(N+1)]
dp = [[0,0] for _ in range(N+1)]

for _ in range(N-1):
    u , v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(node,parent):
    dp[node][0] = 0 # node가 얼리 어답터가 아닐 때
    dp[node][1] = 1 # node가 얼리 어답터인 경우

    for child in graph[node]:
        
        if child == parent:
            continue
        # child랑 parent가 같으면, 
        dfs(child,node)
        #자식 노드들에 대한 dp 값을 먼저 계산 (재귀)

        dp[node][0] += dp[child][1]
        #parent가 얼리어답터 아니면 자식은 무조건 얼리어답터임
        dp[node][1] += min(dp[child][0],dp[child][1])
        #parent가 얼리어답터라면 자식은 두 상태 모두 가능
        #min을 사용하는 이유는 더 적은 얼리 어답터 수를 선택하기 위함

dfs(1,-1)
#1번 노드부터~

print(min(dp[1][0],dp[1][1]))
