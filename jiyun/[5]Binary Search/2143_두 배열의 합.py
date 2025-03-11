import sys
import bisect

def solution(T,N,arr_n,M,arr_m):
    
    # 배열 A와 B에서 부분 배열 합을 구한 후, 합이 T가 되는 쌍의 개수를 찾음
    
    def sum_arr(arr):
        sub_sum = []
        n = len(arr)
        for i in range(n):
            total = 0
            for j in range(i,n):
                total += arr[j] # 더함
                sub_sum.append(total)
        return sub_sum
        
    n_sum = sum_arr(arr_n)
    m_sum = sum_arr(arr_m)
        
    m_sum.sort()
        
    count = 0
    
    for a in n_sum:
        target = T-a
        left = bisect.bisect_left(m_sum,target)
        right = bisect.bisect_right(m_sum,target)
        count += (right - left)
    return count

input = sys.stdin.readline
T = int(input().strip())
N = int(input().strip()) # 배열 A의 크기
arr_n = list(map(int, input().split())) # 배열 A
M = int(input().strip()) # 배열 B의 크기
arr_m = list(map(int, input().split())) # 배열 B

print(solution(T,N,arr_n,M,arr_m))


