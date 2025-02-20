import heapq
n = int(input())
array = []
for _ in range(n):
    deadline, ramen = map(int, input().split())
    array.append((deadline, ramen)) # 튜플로 저장

array.sort() # 튜플 sort 가능함 첫번째 요소 - > 두번째 요소 

queue = []

#우선 순위 큐 
for i in array:
    #i[1] - 컵라면수
    heapq.heappush(queue, i[1])
    # 데드라인이 현재까지 처리한 문제의 개수보다 작으면 -> 시간 없음
    # 우선 순위 큐에서 가장 작은 값을 뺌
    if i[0] < len(queue):
        heapq.heappop(queue)
    
print(sum(queue))