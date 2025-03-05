import sys

input = sys.stdin.readline
N = int(input())
L_arr = list(map(int,input().split()))
L_arr.sort()

left ,right = 0,N-1
min_mixed = sys.maxsize
best_pair = (0,0) # 인덱스 저장


while left < right:
    mixed =L_arr[left] + L_arr[right] # 두 용액의 합
    
    #현재 값이 0에 더 가까우면 갱신함
    if abs(mixed) < min_mixed:
        min_mixed = abs(mixed)
        best_pair = (L_arr[left],L_arr[right])
    
    # 0보다 크면 right (더 작은 값 선택)
    if mixed > 0:
        right -= 1
    else:
        # 0보다 작으면 left 증가
        left += 1    
        
print(best_pair[0],best_pair[1])
    
    
