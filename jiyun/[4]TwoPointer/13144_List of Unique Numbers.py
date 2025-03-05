# 연속 부분 배열 , 투 포인터 문제
import sys


def solution(N,arr):
    left = 0
    right = 0
    visited = set() # 집합
    count =0
    
    # 배열 탐색 시
    while right < N:
        while right < N and arr[right] not in visited:
            visited.add(arr[right])
            right += 1
            count += (right-left) # 부분 수열의 개수
        
        #right를 이동 시키기 위해서 제거해줌
        visited.remove(arr[left]) # 중복이 나왔기 때문에 left를 이동하면서 중복 제거
        left += 1
        
    return count

input = sys.stdin.readline
N = int(input())
arr = list(map(int,input().split()))

print(solution(N,arr))