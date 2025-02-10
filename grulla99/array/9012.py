import sys

n = int(sys.stdin.readline())

a = []

for i in range(n):
    a.append(list(map(str, sys.stdin.readline().rstrip())))

for i in range(n):

    is_valid = True
    cnt = 0
    arr = a[i]

    if arr[0] == ')' or arr[-1] == '(':
        print('NO')

    else:
        for j in arr:
            if j == '(':
                cnt += 1

            else:
                cnt -= 1

            if cnt < 0:
                is_valid = False
                print('NO')
                break

        if cnt == 0 and is_valid:
            print('YES')

        elif cnt != 0 and is_valid:
            print('NO')
