import sys

n = int(sys.stdin.readline().strip())

num_list = list(map(int, sys.stdin.readline().strip().split()))

for i in num_list:
  if i == 1:
    n -=1
  elif i == 2:
    pass
  else:
    for j in range(2, i):
      if i%j == 0:
        n -=1
        break
  
print(n)