import sys
from collections import deque
input = sys.stdin.readline

wheel = list(deque(list(map(int, input().strip()))) for _ in range(4))

#0이 N극  ,,,,, 1이 S극

#1이 시계, -1이 반시

k = int(input())

for _ in range(k):
  state = []
  for i in range(3):
    state.append([wheel[i][2], wheel[i+1][6]])

  wheel_num, direction = map(int, input().split())

  if wheel_num == 1:
    wheel[0].rotate(direction)
    for k in range(3):
      if state[k][0] == state[k][1]:
        break
      else:
        direction = -direction
        wheel[k+1].rotate(direction)

  elif wheel_num == 4:
    wheel[3].rotate(direction)
    for k in range(2, -1, -1):
      if state[k][0] == state[k][1]:
        break
      else:
        direction = -direction
        wheel[k].rotate(direction)
      

  elif wheel_num == 2:
    rdir = direction
    ldir = direction
    wheel[1].rotate(direction)
    a, b = state[0]
    if a != b:
      ldir = -ldir
      wheel[0].rotate(ldir)
    for k in range(1, 3):
      if state[k][0] == state[k][1]:
        break
      else:
        rdir = -rdir
        wheel[k+1].rotate(rdir)

  elif wheel_num == 3:
    rdir = direction
    ldir = direction
    wheel[2].rotate(direction)
    c, d = state[2]
    if c != d:
      rdir = -rdir
      wheel[3].rotate(rdir)
    for k in range(1, -1, -1):
      if state[k][0]  == state[k][1]:
        break
      else:
        ldir = -ldir
        wheel[k].rotate(ldir)

sum = 0

for i in range(4):
  if wheel[i][0] == 1:
    sum += 2**i

print(sum)
  