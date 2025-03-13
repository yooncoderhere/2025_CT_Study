import sys

input = sys.stdin.readline

str = input().rstrip()

m = int(input())
order = []

for _ in range(m):
    order.append(input().rstrip())

cursor = len(str)
for ord in order:
    if ord == 'L':
        if cursor == 0:
            continue
        else:
            cursor = cursor - 1

    elif ord == 'D':
        if cursor == len(str):
            continue
        else:
            cursor = cursor + 1

    elif ord == 'B':
        if cursor == 0:
            continue
        else:
            str = str[:cursor-1] + str[cursor:]
            cursor = cursor - 1

    elif ord[0] == 'P':
        str = str[0:cursor] + ord[2] + str[cursor:]
        cursor = cursor + 1

print(str)