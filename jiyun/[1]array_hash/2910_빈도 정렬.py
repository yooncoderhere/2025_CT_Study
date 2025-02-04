from collections import Counter
import sys

# 빈도 정렬
def solution(N,C,sequence):
    # 등장 빈도 계산
    # N개의 숫자로 이루어짐 숫자들은 C보다 작거나 같음
    freq = Counter(sequence)
    
    # 숫자의 최초 등장 순서를 저장함
    first = {}
    for idx, num in enumerate(sequence):
        if num not in first:
            first[num] = idx 
    
    # 정렬 1 . 빈도수 내림차순
    # 2. 등장 순서 오름차순
    sorted_seq = sorted(sequence, key= lambda x:(-freq[x],first[x]))
    
    # * 리스트의 요소들을 공백으로 구분하여 출력함
    return sorted_seq
    
n,c = map(int,sys.stdin.readline().split())
sequence = list(map(int,sys.stdin.readline().split()))

print(*solution(n,c,sequence))
    