import sys

def solution(N,K,arr):
    left = 0
    count = 0
    max_length = 0
    
    for right in range(N):
        if arr[right] % 2 == 1: # 홀수를 만나면,
            count += 1
        
        #k개 초과로 홀수를 제거해야 하면 left
        while count > K:
            if arr[left] % 2 == 1:
                count -=1
            left += 1
            
        max_length = max(max_length,right-left+1-count)
        
    return max_length

input = sys.stdin.readline
N , K = map(int,input().split())
S = list(map(int,input().split()))

print(solution(N,K,S))