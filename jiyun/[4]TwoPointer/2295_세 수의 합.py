# 2295 세 수의 합
# 세 수를 골라서 세 수의 합이 가장 커지는 경우를 구함

import sys
input = sys.stdin.read

def solution(numbers,N):
    numbers.sort()
    two_sums = set()
    max_val = 0 # 최댓값

    #두 개의 수
    for i in range(N):
        for j in range(i,N):
            two_sums.add(numbers[i] + numbers[j])
    
    # 투 포인터를 사용하여 x-c = a+b 찾기
    for k in range(N):
        left , right = 0,N-1 # 양쪽에 포인터
        while left <= right:
            target = numbers[k] -numbers[left]
            if target in two_sums:
                max_val = max(max_val,numbers[k])
            left +=1 # left 포인터 이동
            
    return max_val
        
        
# 줄 단위로 받음        
numbers = list(map(int,sys.stdin.read().split()))
N = numbers[0] # 자연수 N
numbers = numbers[1:] # U의 원소
print(solution(numbers,N))
