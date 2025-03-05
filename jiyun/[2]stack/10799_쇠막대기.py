# 괄호 문제

def count_cut_pieces(bracket_string):
    stack = []
    total_pieces = 0
    
    for i in range(len(bracket_string)):
        if bracket_string[i] == '(':
            stack.append("(")
        else: # 닫는 괄호인 경우
            stack.pop()
            if bracket_string[i-1] == '(': #모든 ()는 반드시 레이저를 표현함
                total_pieces += len(stack)
            else:
                total_pieces +=1
    return total_pieces

bracket_string = input().strip() #문자열
print(count_cut_pieces(bracket_string))

