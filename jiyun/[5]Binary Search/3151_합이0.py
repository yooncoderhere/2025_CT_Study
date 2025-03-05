import sys
#세 팀원의 코딩 실력의 합이 0이 되는 팀
#투 포인터 문제

def solution(N, A):
    A.sort() # 실력 리스트 정렬
    count =0
    
    #첫번째 숫자 고정
    for i in range(N-2):
        left , right = i+1, N-1
        
        while left < right:
            total = A[i] + A[left] + A[right]
            
            if total == 0:
                if A[left] == A[right]:
                    count += (right-left)*(right - left +1) //2
                    break
                
                l_count , r_count =1,1
                while left + 1 < right and A[left] == A[left + 1]:
                    left += 1
                    l_count += 1
                while right - 1 > left and A[right] == A[right - 1]:
                    right -= 1
                    r_count += 1

                # 가능한 모든 조합 추가
                count += l_count * r_count
                
                # 다음으로 이동
                left += 1
                right -= 1
            
            elif total < 0:
                left += 1  # 합이 작으면 더 큰 값을 찾아야 함
            else:
                right -= 1  # 합이 크면 더 작은 값을 찾아야 함

    return count


input = sys.stdin.readline
N = int(input())
values_arr = list(map(int,input().split()))
print(solution(N,values_arr))