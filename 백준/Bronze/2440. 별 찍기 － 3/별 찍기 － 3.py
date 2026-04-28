import sys

def star2(n):
  if(n>0):
    print('*'*(n))
    return(star2(n-1))


n = int(sys.stdin.readline().strip())
k = n+1

star2(n)