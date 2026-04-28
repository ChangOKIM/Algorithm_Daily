import sys

student_score = []


for i in range(5):
  score = int(sys.stdin.readline().strip())
  if score < 40:
    score = 40
  student_score.append(score)

print(int(sum(student_score)/5))