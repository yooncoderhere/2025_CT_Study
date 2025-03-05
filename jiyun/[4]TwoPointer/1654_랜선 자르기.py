# 1654 랜선 자르기
# N개의 랜선을 만들어야 함
# 영식이는 이미 K개의 랜선을 가지고 있으나 각각의 랜선 길이가 다름
# N개의 같은 길이의 랜선을 만들고 싶어, K개의 랜선을 잘라서 만듬

# K의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없음
import sys


def solution(K,N,cables):
    
    left , right = 1,max(cables) # 길이
    result = 0
    
    while left <= right:
        mid = (left+right)//2 # 현재 탐색할 랜선 길이
        count = sum(cable//mid for cable in cables) # mid길이로 자름
        
        if count >= N: # 랜선 개수가 충분하면 길이를 늘림
            result = mid
            left = mid +1
        else:
            right = mid -1
        
    return result

input = sys.stdin.read
#unpack
K , N , *cables= map(int,input().split())
print(solution(K,N,cables))