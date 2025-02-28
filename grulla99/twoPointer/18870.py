import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
set_sorted_arr = sorted(list(set(arr)))
dic = {}

for i in range(len(set_sorted_arr)):
    dic[set_sorted_arr[i]] = i

for i in arr:
    print(dic[i], end = ' ')