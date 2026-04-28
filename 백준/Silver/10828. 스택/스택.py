#백준 - 10828번
#스택 요리저리
import sys


n = int(sys.stdin.readline().strip())

result = []

for i in range(n):
  cmd = sys.stdin.readline().split()
  if cmd[0] == 'push':
    a = int(cmd[1])
    result.append(a)
  elif cmd[0] == 'pop':
    if len(result) > 0:
      print(result.pop())
    else:
      print(-1)
  elif cmd[0] == 'size':
    print(len(result))
  elif cmd[0] ==  'empty':
    if len(result) == 0:
      print(1)
    else:
      print(0)
  elif cmd[0] == 'top':
    if len(result) != 0:
      print(result[-1])
    else:
      print(-1)
  cmd = 0
