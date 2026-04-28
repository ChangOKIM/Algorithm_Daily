import sys

def star6(yeah):
  if yeah <=n:
    print(' '*(yeah-1) + '*'*((2*n-1) - 2*(yeah-1)))
    return(star6(yeah+1))


n = int(sys.stdin.readline().strip())
k = 1

star6(k)