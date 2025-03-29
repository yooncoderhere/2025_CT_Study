import sys
# from itertools import permutations

input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))

arr = []
visited = [False] * n
result = float('-inf')

def back_tracking(depth):
    global result
    # 내가 찾는 조건이 맞을 때
    if depth == n:
        ans = 0
        for i in range(n-1):
            ans += abs(a[arr[i]] - a[arr[i+1]])
        result = max(result, ans)
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            arr.append(i)
            back_tracking(depth + 1)
            visited[i] = False
            arr.pop()

back_tracking(0)
print(result)

# 내 생각
# 답을 보기전
# 1. 결과값을 저장하는 리스트 생성
# 2. 결과값을 도출하는 함수 생성
# 3. 수를 적절히 바꾸는 함수 생성
# 이건데 이렇게하면 시간복잡도에서 오류 터질 것 같음 메모리나
# 일단 수를 적절히 바꾸는 함수를 어떻게 구현해야할지 감이 앉잡힘
# 어떻게 바꿔야 이득일지 같은 거?

# 답 1번
# n 값이 작으니 모든 경우의 수를 전부 구한다 순열 -> 720개
# 모든 경우의 수에 대한 값을 전부 비교해서 정답 구하기

# 답 2번
