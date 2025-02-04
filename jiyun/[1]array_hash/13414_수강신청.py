import sys

#
def course_registration(k, l, student_ids):
    student_dict = {}  # {학번: 마지막 신청 순서}
    
    for student_id in student_ids:
        if student_id in student_dict:  
            del student_dict[student_id]  # 기존 학번 삭제 (맨 뒤로 보내기 위해)
        student_dict[student_id] = True  # 최신 신청 순서로 추가
    
    # 수강 신청이 가능한 K명의 학번 출력
    registered_students = list(student_dict.keys())[:k]
    return registered_students

# 입력 처리
k, l = map(int, sys.stdin.readline().split())  # 수강 가능 인원 K, 대기 목록 길이 L
student_ids = [sys.stdin.readline().strip() for _ in range(l)]  # 학번 리스트

# 결과 출력
for student in course_registration(k, l, student_ids):
    print(student)
