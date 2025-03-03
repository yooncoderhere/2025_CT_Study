import sys

#최대한 긴 과자를 나눠주려고 함
#단, 모든 조카에서 동일한 길이의 과자를 나눠줘야 함
#M명의 조카가 있고 N개의 과자가 있을 때 조카 1명에게 줄 수 있는 막대 과자의 최대 길이


def solution(M,snacks):
    # 이분 탐색을 기반으로 최대 과자 길이 찾기
    
    left,right =1,max(snacks) # 최소 과자 길이 1, 가장 긴 과자의 길이
    result =0
    
    while left <= right:
        mid = (left+right) //2 # 
        count = sum(snack//mid for snack in snacks)
        
        if count >= M: # 조카 수보다 count가 많으면
            result = mid
            left = mid +1
        else:
            right = mid -1
    return result

input = sys.stdin.read
M, N , *snacks= map(int,input().split())
# 조카 수, 과자의 수, 과자 길이

print(solution(M,snacks))