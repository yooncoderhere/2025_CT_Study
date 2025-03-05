# 문제
# 우주가 균등하다는 조건
# 행성 간 크기 순서가 통일하면 같은 우주로 간주(좌표 압축 문제) 

import sys
from collections import defaultdict

def solution(k,n, universes):
    
    patterns_dict = defaultdict(int) # 패턴 개수 저장
    result = 0
    
    for universe in universes:
        sorted_uni = sorted(set(universe)) # 중복 제거 후 정렬
        #중복을 제거 해도 되나..
        indxe_map = {value : idx for idx, value in enumerate(sorted_uni)}
        pattern = tuple(indxe_map[x] for x in universe)
        
        result += patterns_dict[pattern]
        patterns_dict[pattern] +=1
    
    return result # 균등한 우주의 쌍의 개수 출력
input = sys.stdin.read
k,n,*universes= map(int,input().split()) # 우주 개수 k , 행성 개수 n
universes = [universes[i*n:(i+1)*n] for i in range(k)]
print(solution(k,n,universes))