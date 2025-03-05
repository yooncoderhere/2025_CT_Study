#줄의 개수 N / 현재 줄의 탭의 개수 / 각 줄의 올바른 탭의 개수
#선택된 줄의 앞에 탭 1개를 추가하거나 삭제
#추가와 삭제는 동시에 할 수 없음
#최소한의 편집 횟수

#greedy 방식으로 풀이함

n = int(input())
current_state = list(map(int,input().split()))
correct_state = list(map(int,input().split()))

count = 0 # 탭을 수정한 횟수
state = [0,1,2] # 0:초기상태, 1:이전에탭을삭제 , 2:이전에탭을추가

while current_state != correct_state:
    for i in range(n): # 각 줄을 한 번씩 탐색
        if current_state[i] == correct_state[i]: # 동일하다면 유지
            continue
            
        elif current_state[i] > correct_state[i]:
            if state !=1: # 이전에 탭을 삭제하지 않았다면
                count +=1
                current_state[i] -=1
                state =1 # 감소하는 상태로 변경함
            else:
                current_state[i] -=1
        else:
            if state != 2:
                # 이전에 탭을 추가하지 않았으면
                count +=1
                current_state[i] +=1
                state = 2
print(count)