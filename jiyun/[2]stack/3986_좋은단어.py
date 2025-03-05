import sys

def solution(word):
    stack = []
    for char in word:
        if stack and stack[-1] == char:
            stack.pop()
        else:
            stack.append(char)
    return 1 if not stack else 0
     
n = int(sys.stdin.readline().strip())
count = 0

for _ in range(n):
    word = sys.stdin.readline().strip()
    count += solution(word)
    
print(count)