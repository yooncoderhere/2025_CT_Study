import sys
input = sys.stdin.readline

s = input().strip()
bombs = input().strip()

def solution(s,bomb):
    stack = []
    bomb_len = len(bombs) # 폭발 문자열
    
    for char in s:
        stack.append(char) # 문자 추가
        #스택의 마지막 부분(stack[-bomb_len])이 폭발 문자열과 일치
        if ''.join(stack[-bomb_len:]) == bomb:
            del stack[-bomb_len:] # 폭발 문자열 제거
            
    result = ''.join(stack)
    return result if result else "FRULA"

print(solution(s,bombs))