import sys
input = sys.stdin.readline

N = int(input())
words = [(input().strip(), i) for i in range(N)]
prefix = ''
answer_min_idx = float('inf')
words.sort()

for i in range(N-1) :
  if words[i][0] == words[i+1][0] :
    continue
  maxlen = min(len(words[i][0]), len(words[i+1][0]))
  min_idx = min(words[i][1], words[i+1][1])
  for j in range(maxlen) :
    if words[i][0][j] != words[i+1][0][j] :
      break
    if j == maxlen-1 :
      j += 1
  if len(prefix) < j or len(prefix) == j and min_idx < answer_min_idx :
    prefix = words[i][0][:j]
    answer_min_idx = min_idx

answer = list()
for word, idx in words :
  if word[:len(prefix)] == prefix :
    answer.append((word, idx))
answer.sort(key = lambda x : x[1])
for word in answer[:2] :
  print(word[0])