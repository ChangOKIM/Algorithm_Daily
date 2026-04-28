import sys

n = int(sys.stdin.readline().strip())

cp = []

for i in range(n):
  cp.append(list(map(int, sys.stdin.readline().strip().split())))
  

cp.sort(key = lambda x : (x[0], x[1]))

for j in range(n):
  print(cp[j][0], cp[j][1])