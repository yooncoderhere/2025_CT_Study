import sys

n = int(sys.stdin.readline())  # 입력값 n (숫자의 개수)
sequence = [int(sys.stdin.readline()) for _ in range(n)]  # 수열 입력

stack = []  # 스택을 저장할 리스트
result = []  # 연산 결과 저장 리스트
current = 1  # 스택에 넣을 숫자 (1부터 시작)
possible = True  # 주어진 수열을 만들 수 있는지 여부

for num in sequence: 
    #for 문 - while 문으로 current를 증가 시킨다
    while current <= num:  # 현재 숫자가 num이 될 때까지 push
        #print(current)
        stack.append(current)
        result.append("+")
        current += 1
    
    if stack[-1] == num:  # 스택의 top이 num과 같으면 pop
        stack.pop()
        result.append("-")
    else:  # 수열을 만들 수 없는 경우
        possible = False
        break

if possible:
    print("\n".join(result))  # 연산 결과 출력
else:
    print("NO")  # 수열을 만들 수 없음
