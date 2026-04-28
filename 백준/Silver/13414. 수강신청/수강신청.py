import sys

K, L = map(int, sys.stdin.readline().strip().split())

applicants = dict()

for _ in range(L):
    student_id = sys.stdin.readline().strip()
    if student_id in applicants:
        del applicants[student_id]
    applicants[student_id] = True

count = 0
for student_id in applicants:
    if count == K:
        break
    print(student_id)
    count += 1
