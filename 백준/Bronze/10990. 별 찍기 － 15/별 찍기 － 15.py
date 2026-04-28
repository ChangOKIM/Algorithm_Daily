import sys

def star15(init):
  if init == n:
    empty = init-1
    print(' '*empty + '*')
    return(star15(init-1))
  else:
    while(init>0):
      empty = init-1
      middle = gap - (2*init + 1)
      print(' '*empty + '*' + ' '*middle + '*')
      return(star15(init-1))



n = int(sys.stdin.readline().strip())
gap = 2*n


star15(n)