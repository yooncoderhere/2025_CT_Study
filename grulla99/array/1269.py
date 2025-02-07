import sys

n, m = map(int, sys.stdin.readline().split())

a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

a.sort()
b.sort()

def count_diff(sorted_list, other_list):
    cnt = len(sorted_list)
    for i in other_list:
        left = 0
        right = len(sorted_list) - 1
        while left <= right:
            mid = (left + right) // 2
            if sorted_list[mid] == i:
                cnt -= 1
                break
            elif sorted_list[mid] < i:
                left = mid + 1
            else:
                right = mid - 1
    return cnt

result = count_diff(a, b) + count_diff(b, a)
print(result)