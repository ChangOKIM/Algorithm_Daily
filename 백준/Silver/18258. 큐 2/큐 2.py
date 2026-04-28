#백준 - 18258번
# 큐 2
from collections import deque
import sys


n = int(sys.stdin.readline().strip())
queue_list = deque([])

for i in range(n):
  command = list(sys.stdin.readline().strip().split())
  if command[0] == 'push':
    queue_list.append(int(command[1]))
  elif command[0] == 'pop':
    if len(queue_list) == 0:
      print(-1)
    else:
      print(queue_list.popleft())
  elif command[0] == 'size':
    print(len(queue_list))
  elif command[0] == 'empty':
    if len(queue_list) == 0:
      print(1)
    else:
      print(0)
  elif command[0] == 'front':
    if len(queue_list) != 0:
      print(queue_list[0])
    else:
      print(-1)
  elif command[0] == 'back':
    if len(queue_list) != 0:
      print(queue_list[-1])
    else:
      print(-1)

  
