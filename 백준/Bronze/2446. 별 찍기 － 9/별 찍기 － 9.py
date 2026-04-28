import sys

def top(init):
  if(init <= n):
    print(' '*(init-1) + '*'*(2*(n-init)+1))
    return(top(init + 1))


def bottom(init):
  if(init >=0):
    print(' '*init + '*'*(2*(n-init)-1))
    return(bottom(init - 1))


n = int(sys.stdin.readline().strip())
first = 1
last = n-2

top(first)
bottom(last)