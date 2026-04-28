import sys

n = int(sys.stdin.readline().strip())

num_array = []

for i in range(n):
  num_array.append(int(sys.stdin.readline().strip()))

answer = list(sorted(num_array))

for i in range(len(answer)):
  print(answer[i])