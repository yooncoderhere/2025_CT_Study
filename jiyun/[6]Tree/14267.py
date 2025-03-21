# 회사 문화 1

# 내리 칭찬 -> dfs로 풀어야겠다
# 칭찬의 수치는 모두 같다
# 각 직원마다 얼마의 칭찬을 받았는지
import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

n, m = map(int,input().split())
# 회사 직원의 수 , 최초 칭찬의 횟수

boss = list(map(int, input().split()))
# 상사의 번호

graph = [[] for _ in range(n+1)]
# 직속 상사와 직속 부하 관계 표현 1:1 관계임
# dict가 아닌 list로 받는 이유는
# 1-N의 연속된 수 (직원 수) 이기 때문에??
# 0번은 사용하지 않음

for i in range(1, n):
    graph[boss[i]].append(i+1)
    # 근데 이건 일반적인 트리 구조라고 보기에 무리가 있음
    # 문제를 이해 못함

praise = [0] * (n+1)
# 칭찬 점수 배열

for _ in range(m):
    i, w = map(int, input().split())
    # 직원 번호 i / 칭찬 수치 w
    praise[i] += w
    # 칭찬 저장

#그래프를 어디서 사용하지? dfs 에서

def dfs(node):

    for child in graph[node]:
        praise[child] += praise[node]
        # 상사(node)가 받은 칭찬을 
        # #부하 직원(child)누적 전파?
        dfs(child)
        #다음 부하 호출

dfs(1)

print(' '.join(map(str, praise[1:])))

        