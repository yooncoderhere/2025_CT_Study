import sys

input = sys.stdin.readline

n, m = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort()


def binary_sarch(a, b):
    result = []

    for i in a:
        start = 0
        end = len(b) - 1
        found = False
        while start <= end:
            mid = (start + end) // 2
            if b[mid] == i:
                found = True
                break
            elif b[mid] < i:
                start = mid + 1
            else:
                end = mid - 1
        if not found:
            result.append(i)
    return result

result = binary_sarch(a, b)

if len(result) == 0:
    print(0)
else:
    print(len(result))
    print(" ".join(map(str, result)))
