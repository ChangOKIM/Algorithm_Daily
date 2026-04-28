import sys

def star5(init):
  if init <= n:
    print(' '*(n-init) + '*'*(2*init - 1))
    return star5(init + 1)
    



n = int(sys.stdin.readline().strip())
init = 1
star5(init)