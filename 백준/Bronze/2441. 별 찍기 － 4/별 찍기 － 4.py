import sys

def star4(n):
  if(n>0):
    print(' '*(k-n) + '*'*(n))
    return(star4(n-1))
  

n = int(sys.stdin.readline().strip())

k = n

star4(n)