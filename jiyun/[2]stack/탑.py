import sys
def solution(n,heights):
    
    stack = [] # 스택의 탑의 인덱스를 저장함
    result = [0]*n
    
    for i in range(n):
        while stack and heights[stack[-1]] < heights[i]:
            #현재 탑보다 낮은 탑 제거
            stack.pop()
            
        if stack:
            result[i] = stack[-1] +1
        
        stack.append(i)
        
    return "".join(map(str,result))
    

n= int(sys.stdin.readline())
heights = list(sys.stdin.readline() for _ in range(n))
solution(n,heights)