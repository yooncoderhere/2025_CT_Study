# 민서의 응급 수술

# 최소 연산 횟수 -> bfs 로 풀자

from collections import deque # 덱을 불러옴


def bfs(node):

    queue = deque([node])
    # bfs는 덱을 기반으로 가장 가까운 노드부터 탐색한다
    visited[node] = True
    # 방문 표시
    edge_count = 0
    # 간선 개수
    node_count =0 
    # 노드 개수

    while queue:
        node=queue.popleft()
        # 노드를 한 개 꺼내서
        node_count += 1
        # 노드 개수 증가?
        for neighbor in tree[node]:
            edge_count += 1
            # 양방향 간선이기 때문에 2번씩 증가?
            if not visited[neighbor]:
                #만약 방문하지 않은 노드라면,
                visited[neighbor] = True
                # 해당 노드를 방문 표시한 후,
                queue.append(neighbor)
                # 큐에 넣는다

    return edge_count//2, node_count
# 간선 개수 / 노드 개수 반환

N , M = map(int,input().split()) 
# 노드 개수 ,간선 개수 
tree = {i:[] for i in range(1,N+1)}
# 노드 개수에 맞게 tree를 dict로 만들어준다
visited = [False] * (N+1)
# 방문 표시 (노드 개수만큼)

#트리 생성
for _ in range(M):
    u , v = map(int,input().split()) # 두 뉴런의 번호
    tree[u].append(v)
    tree[v].append(u)


#BFS를 통해서 연결 요소 개수와 사이클 개수 찾기
cnt = 0
#
cycle_count = 0
# 사이클이 있는 경우 제거 해야하는 간선 개수

for i in range(1,N+1):
    if not visited[i]:
        cnt += 1
        # 연산 횟수 추가
        edge_count , node_count = bfs(i) 
        #bfs 탐색 수행 
        cycle_count += (edge_count-(node_count-1))
        #초과된 간선 개수
        #근데 반드시 이렇게 제거를 수행해줘야 하는지?
print((cnt-1)+ cycle_count)
# 출력





