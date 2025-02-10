#괄호는 () 만 존재함
#괄호의 모양이 바르게 구성된 문자열을 VPS라고 함

def is_vps(ps):
    stack = []
    for char in ps:
        if char ==  '(':
            stack.append(char) # 여는 괄호면 스택에 추가
        elif char == ')': # 닫는 괄호면 스택에서 제거
            if stack: # 스택이 비어있지 않는 경우
                stack.pop()
                #print("stack pop")
            else: # 스택이 비어 있는데 닫는 괄호가 나온 경우
                return "NO"
    return "YES" if not stack else "NO" # 스택이 비어있으면 올바른 괄호 문자열임

T=int(input()) # 입력 처리
result = []
for _ in range(T): # 테스트 케이스 개수
    ps = input().strip()
    result.append(is_vps(ps))
    
print("\n".join(result)) # 줄바꿈 출력
