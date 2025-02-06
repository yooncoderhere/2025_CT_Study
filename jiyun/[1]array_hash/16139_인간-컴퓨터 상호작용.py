import sys

s = sys.stdin.readline().strip() # 문자열
q = int(sys.stdin.readline()) # 질문의 수

#알파벳 개수 저장
n = len(s)
prefix = [[0]* (n+1) for _ in range(26)] # 26개

for i in range(n):
    char_index = ord(s[i])-ord('a')
    for j in range(26):
        prefix[j][i+1] = prefix[j][i] 
    prefix[char_index][i+1] += 1

output=[]
#질의처리
for _ in range(q):
    # l번째 문자부터 r문자 사이에 알파가 몇번 나타는지
    alpha, l, r = sys.stdin.readline().split()
    l,r = int(l), int(r) # 정수 변환
    
    alpha_index = ord(alpha) - ord('a')
    result = prefix[alpha_index][r+1] - prefix[alpha_index][l]
    #
    output.append(str(result))
    
sys.stdout.write("\n".join(output)+ "\n")