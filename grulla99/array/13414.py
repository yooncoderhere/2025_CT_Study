import sys

k, l = map(int, sys.stdin.readline().split())

last_click = {}

for i in range(l):
    student = sys.stdin.readline().strip()
    last_click[student] = i

sorted_students = sorted(last_click.items(), key=lambda x: x[1])

for student, _ in sorted_students[:k]:
    print(student)