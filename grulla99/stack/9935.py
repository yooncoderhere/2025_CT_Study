mystr = input().strip()
target = input().strip()

stack = []
target_ = len(target)

for i in range(len(mystr)) :
    stack.append(mystr[i])
    if ''.join(stack[-target_:]) == target :
        for j in range(target_):
            stack.pop()

if stack :
    print("".join(stack[:]))
else :
    print("FRULA")