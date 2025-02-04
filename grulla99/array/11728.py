import sys

n, m = map(int, sys.stdin.readline().split())

arr1 = list(map(int, sys.stdin.readline().split()))
arr2 = list(map(int, sys.stdin.readline().split()))

sum = arr1 + arr2
sum.sort()

print(' '.join(map(str, sum)))