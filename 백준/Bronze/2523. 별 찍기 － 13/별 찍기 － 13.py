import sys

def star12_top(init):
  while(init >=0):
    print('*'*(n-init))
    return(star12_top(init-1))

def star12_bottom(init):
  while(init <n):
    print( '*'*(n-init))
    return(star12_bottom(init+1))
  


n = int(sys.stdin.readline().strip())
empty = n-1
empty_bottom = 1

star12_top(empty)
star12_bottom(empty_bottom)