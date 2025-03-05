#나무 M미터 , 절단기 높이 H
#적어도 M 미터의 나무를 집에 가져가기 위해 
#절단기에 설정할 수 있는 높이의 최댓값

# 특정 범위 안에서 

import sys

def solution(M,trees):
    left , right = 0, max(trees)
    result = 0
    
    #포맷이 항상 비슷
    while left <= right:
        
        mid = (left + right) //2
        # 현재 절단기 높이(mid)보다 높은 부분만 잘라서 가져가는 방식
        # 얻은 나무의 길이
        total = sum(tree-mid for tree in trees if tree > mid)
        
        if total>= M: # 나무 수가 충분하면 높이를 올림
            result = mid
            left = mid +1
        else:
            right = mid -1
    return result
            
input = sys.stdin.read
N , M , *trees = map(int, input().split())
#*trees 언패킹 연산자

print(solution(M,trees))



