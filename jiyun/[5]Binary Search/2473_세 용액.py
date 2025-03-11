import sys

def solution(N,N_arr):
    N_arr.sort()
    sum_total = sys.maxsize
    best_pairs = (0,0,0)
    
    # 세 개의 용액을 골라야함 -> 마지막 두개는 투포인터를 이용해서 찾음
    for i in range(N-2):
        left, right = i+1 , N-1
        
        while left < right:
            total = N_arr[i] + N_arr[left] + N_arr[right]

            # 현재 합이 0에 더 가까우면 최적 조합 갱신
            if abs(total) < abs(sum_total):
                sum_total = total
                best_pairs = (N_arr[i], N_arr[left], N_arr[right])

            # 투 포인터 이동
            if total < 0:
                left += 1  # 합이 작으면 더 큰 값 필요
            else:
                right -= 1  # 합이 크면 더 작은 값 필요
                
    return best_pairs

input= sys.stdin.readline
N = int(input())
N_arr = list(map(int, input().split()))

print(*solution(N,N_arr)) # 튜플을 값을 공백으로 구분하여 출력 *

