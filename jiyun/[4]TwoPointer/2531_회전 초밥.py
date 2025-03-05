import sys

#손님이 "연속해서" 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 문제
#순서 있음 (9,7,30,2) / (30,2,7,9)

#벨트 상태, 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호

input = sys.stdin.readline

# 접시의 수, 초밥 가짓수, 연속해서 먹는 개수, 쿠폰 번호
N , d , k , c = map(int,input().split())

#벨트의 한 위치부터 시작하여 회전 방향을 따라서 (초밥의 종류를 받음)
sushis = [int(input().strip()) for _ in range(N)]

#슬라이딩 윈도우 정의
sushi_num = [0] * (d+1)
unique_sushi = 0 # 먹을 수 있는 초밥의 가짓수


#초기 윈도우 설정 부분
# 처음 k의 초밥 확인
for i in range(k):
    if sushi_num[sushis[i]] == 0: # 처음 들어온 초밥
        unique_sushi += 1 # 종류 증가
    sushi_num[sushis[i]] += 1 #  # 현재 윈도우 내에 몇개가 있는지
    
max_sushi = unique_sushi
if sushi_num[c] == 0: # 쿠폰 초밥이 없다면
    max_sushi +=1

#슬라이딩 윈도우 실행
for i in range(N):
    #이전 초밥 제거
    remove_sushi = sushis[i]
    sushi_num[remove_sushi] -=1
    if sushi_num[remove_sushi] == 0: #더 이상 없음
        unique_sushi -=1
        
    # 암기
    new_sushi = sushis[(i+k)%N] #새롭게 들어온 스시 추가
    if sushi_num[new_sushi] == 0:
        unique_sushi +=1
    sushi_num[new_sushi] +=1 # 초밥 개수 증가
    
    #쿠폰 초밥이 있는 확인하고 최댓값을 갱신함
    current_max = unique_sushi + (1 if sushi_num[c] == 0 else 0)
    max_sushi = max(max_sushi,current_max)
    
print(max_sushi)