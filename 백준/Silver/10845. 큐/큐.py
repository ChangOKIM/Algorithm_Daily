#백준 - 10845번
# 큐의 기본 논리

from collections import deque
import sys

n = int(sys.stdin.readline().strip())

result = deque([])

for i in range(n):
  command = sys.stdin.readline().strip().split()
  if command[0] == 'push':
    result.append(command[1])
  elif command[0] == 'pop':
    if len(result) == 0:
      print(-1)
    else:
      print(result.popleft())
  elif command[0] == 'size':
    print(len(result))
  elif command[0] == 'empty':
    if len(result) == 0:
      print(1)
    else:
      print(0)
  elif command[0] == 'front':
    if len(result) == 0:
      print(-1)
    else:
      print(result[0])
  elif command[0] == 'back':
    if len(result) == 0:
      print(-1)
    else:
      print(result[-1])