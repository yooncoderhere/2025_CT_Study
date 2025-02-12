def infix_to_postfix(expression):
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '(': 0}  # 연산자 우선순위
    stack = []  # 연산자를 저장할 스택
    result = []  # 후위 표기식 결과

    for char in expression:
        if char.isalpha():  # 피연산자 (A-Z) 그대로 추가
            result.append(char)
        elif char == '(':  # 여는 괄호는 스택에 push
            stack.append(char)
            print(stack)
        elif char == ')':  # 닫는 괄호가 나오면 '('를 만날 때까지 pop
            while stack and stack[-1] != '(':
                result.append(stack.pop())
            if stack:  # 스택이 비어있지 않으면 '(' 제거
                stack.pop()
        else:  # 연산자 처리 (+, -, *, /)
            while stack and precedence.get(stack[-1], -1) >= precedence.get(char, -1):  # 우선순위 비교
                #print(precedence.get(stack[-1], -1))
                result.append(stack.pop())
            stack.append(char)
            

    while stack:  # 스택에 남아있는 연산자 모두 출력
        result.append(stack.pop())

    return ''.join(result)

# 입력 받기
expression = input().strip()  # sys.stdin.readline() 대신 input() 사용
print(infix_to_postfix(expression))  # 후위 표기식 변환 후 출력
