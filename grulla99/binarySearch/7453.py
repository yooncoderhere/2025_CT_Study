import sys

input = sys.stdin.readline

n = int(input())
A = []
B = []
C = []
D = []

for _ in range(n):
    a, b, c, d, = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

cnt = 0

sum_ab = {}
for a in A:
    for b in B:
        AB = a+b
        if AB in sum_ab:
            sum_ab[AB] += 1
        else:
            sum_ab[AB] = 1

for c in C:
    for d in D:
        sum_cd = -1 * (c+d)
        if sum_cd in sum_ab:
            cnt += sum_ab[sum_cd]

print(cnt)
# D.sort()
# set_A = list(set(A))
# set_B = list(set(B))
# set_C = list(set(C))
#
# cnt = 0
# for i in range(len(set_A)):
#     for j in range(len(set_B)):
#         for k in range(len(set_C)):
#             num = -1 * (set_A[i] + set_B[j] + set_C[k])
#
#             start = 0
#             end = n - 1
#             while start <= end:
#                 mid = (start + end) // 2
#
#                 if D[mid] < num:
#                     start = mid + 1
#
#                 elif D[mid] == num:
#                     cnt += 1
#                     break
#
#                 else:
#                     end = mid - 1
#
# print(cnt)