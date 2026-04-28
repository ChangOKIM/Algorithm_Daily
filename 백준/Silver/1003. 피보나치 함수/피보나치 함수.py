import sys

t = int(sys.stdin.readline().strip())

for i in range(t):
  n = int(sys.stdin.readline().strip())
  np_zero = [0]*(n+1)
  np_zero[0] = 1
  if n>=1:
    np_zero[1] = 0
  if n>1:
    for i in range(2, n+1):
      np_zero[i] = np_zero[i-1] + np_zero[i-2]
  np_one = [0]*(n+1)
  np_one[0] = 0
  if n>=1:
    np_one[1] = 1
  if n>1:
    for j in range(2, n+1):
      np_one[j] = np_one[j-1] + np_one[j-2]
  print(np_zero[n], np_one[n])