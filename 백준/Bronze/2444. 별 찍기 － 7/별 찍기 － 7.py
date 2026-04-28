import sys


def diamond(wow):
  while (wow <= n):
    print(' ' * (n - wow) + '*' * (2 * wow - 1))
    return (diamond(wow + 1))

def dia(mom):
  while (mom >0):
    print(' '*(n-mom) + '*'*(2*mom-1))
    return (dia(mom -1))


n = int(sys.stdin.readline().strip())
init = 1
mom = n-1

diamond(init)
dia(mom)
