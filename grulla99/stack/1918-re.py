arr = input()
stack = []
result = ''

for i in arr:
    if i == '(':
        stack.append(i)
    elif i == ')':
        while stack and stack[-1] != '(':
            result += stack.pop()
        stack.pop()
    elif i == '*' or i == '/':
        while stack and (stack[-1] == '*' or stack[-1] == '/'):
            result += stack.pop()
        stack.append(i)
    elif i == '+' or i == '-':
        while stack and stack[-1] != '(':
            result += stack.pop()
        stack.append(i)
    else:
        result += i

while stack:
    result += stack.pop()
print(result)
