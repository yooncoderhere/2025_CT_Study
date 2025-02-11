import sys

N = int(sys.stdin.readline().strip()) # 피연산자 개수
expression = sys.stdin.readline().strip() # 후위 표기식
values= [int(sys.stdin.readline().strip()) for _ in range(N)] # 각 피연자 값 저장

#피 연산자값 저장
operand_dict = {chr(65 +i): values[i] for i in range(N)}
# {'A':1, 'B':2, ...}

stack = []

for char in expression:
    if char.isalpha(): # 피연산자이면,
        stack.append(operand_dict[char])
    else:
        b = stack.pop()
        a = stack.pop()
        
        if char == '+':
            stack.append(a+b)
        elif char == '-':
            stack.append(a-b)
        elif char == '*':
            stack.append(a*b)
        elif char == '/':
            stack.append(a/b)

print(f"{stack[-1]:.2f}") # 소수점 둘째짜리까지 