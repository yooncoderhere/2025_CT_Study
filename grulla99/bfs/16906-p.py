import sys

input = sys.stdin.readline

n = int(input())
lengths = list(map(int, input().split()))

words = [(lengths[i], i) for i in range(n)]
words.sort(key=lambda x: x[0])

assigned = [None] * n
code = 0
prev_length = words[0][0]

for L, idx in words:

    if L > prev_length:
        code = code << (L - prev_length)

        print(-1)
        sys.exit()

    word = format(code, 'b').zfill(L)
    assigned[idx] = word
    code += 1
    prev_length = L


for word in assigned:
    print(word)