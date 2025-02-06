import sys

s = sys.stdin.readline().strip()

count_0 = 0 # 연속된 0 그룹 개수
count_1 = 0 # 연속된 1 그룹 개수

if s[0] == '0':
    count_0 +=1
else:
    count_1 +=1
    
for i in range(1,len(s)):
    if s[i] != s[i-1]:
        if s[i] == '0': # 문자열
            count_0 +=1
        else:
            count_1 +=1
            
#최소 뒤집기 횟수 출력
print(min(count_0,count_1))