import sys

def count_valid_passwords(s, p, dna, min_counts):
    # Step 1: 초기 윈도우 설정
    
    #문자 개수 저장 dict
    current_counts = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
    
    for i in range(p):  # 부분 문자열 P 분석
        current_counts[dna[i]] += 1 # p 를 이루는 문자 개수 저장

    # 조건을 만족하는지 확인하는 함수
    def is_valid():
        return (current_counts['A'] >= min_counts[0] and
                current_counts['C'] >= min_counts[1] and
                current_counts['G'] >= min_counts[2] and
                current_counts['T'] >= min_counts[3])

    # Step 2: 초기 윈도우 확인
    valid_count = 1 if is_valid() else 0

    # Step 3: 슬라이딩 윈도우 이동
    for i in range(p, s):  
        new_char = dna[i]  # 새로 추가될 문자
        old_char = dna[i - p]  # 제거될 문자

        current_counts[new_char] += 1  # 새 문자 추가
        current_counts[old_char] -= 1  # 이전 문자 제거

        if is_valid():  # 조건 만족하면 카운트 증가
            valid_count += 1

    return valid_count

# 입력 처리
s, p = map(int, sys.stdin.readline().split())  # 문자열 길이 S, 부분문자열 길이 P
dna = sys.stdin.readline().strip()  # DNA 문자열
min_counts = list(map(int, sys.stdin.readline().split()))  # 최소 개수 [A, C, G, T]

# 결과 출력
print(count_valid_passwords(s, p, dna, min_counts))
