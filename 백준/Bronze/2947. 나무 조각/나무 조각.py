import sys

def make_asc(n):
  for j in range(len(n)):
    for i in range(len(n)-1):
      if n[i] > n[i+1]:
        n[i], n[i+1] = n[i+1], n[i]
        print(*n)
  

n = list(map(int, sys.stdin.readline().strip().split()))

make_asc(n)