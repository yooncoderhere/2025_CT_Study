# 각 숫자의 오른쪽에서 자기보다 크면서 가장 가까운 숫자는 찾는 문제
import sys

def solution(n,arr):
    stack = [] # 오큰수를 찾기 못한 인덱스룰 저장하는 스택
    result = [-1]*n
    
    for i in range(n):
        while stack and arr[stack[-1]] < arr[i]:
            index = stack.pop()
            result[index] = arr[i]
        stack.append(i) # 현재 인덱스를 스택에 추가함
        
    print(*result)
    
n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split()))
solution(n,arr)
            