import sys

#m 을 넘지않는 mㅇ에 최대한 가까운 숫자 카드 3장의 합
input = sys.stdin.readline

n, m = map(int, input().split())

a = list(map(int, input().split()))
arr = []
visited = [False] * n
result = 0

def back(depth):
    # 조건문
    global result
    if depth == 3:
        ans = 0
        for i in range(3):
            ans += a[arr[i]]
        if ans <= m:
            result = max(result, ans)
        return
    # 백트래킹 적용 부분
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            arr.append(i)
            back(depth + 1)
            visited[i] = False
            arr.pop()

back(0)
print(result)