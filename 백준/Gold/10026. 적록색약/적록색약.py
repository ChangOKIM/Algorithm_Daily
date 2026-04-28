import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

graph = list([0 for _ in range(N)] for _ in range(N))

graph_rg = list([0 for _ in range(N)] for _ in range(N))

for lines in range(N):
  RGB = list(str(input()))
  for idx in range(len(RGB)-1):
    if RGB[idx] == 'R':
      graph[lines][idx] = 0
      graph_rg[lines][idx] = 0
    elif RGB[idx] == 'G':
      graph[lines][idx] = 1
      graph_rg[lines][idx] = 0
    elif RGB[idx] == 'B':
      graph[lines][idx] = 2
      graph_rg[lines][idx] = 2

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

count = 0
count_rg = 0


for y in range(N):
  for x in range(N):
    if graph[y][x] != 100:
      count += 1
      remember = graph[y][x]
      queue = deque([(x, y)])
      graph[y][x] = 100
      while queue:
        cx, cy = queue.popleft()
        for i in range(4):
          nx, ny = cx + dx[i], cy + dy[i]
          if 0 <= nx < N and 0 <= ny < N and graph[ny][nx] == remember:
            graph[ny][nx] = 100
            queue.append((nx, ny))

for y in range(N):
  for x in range(N):
    if graph_rg[y][x] != 100:
      count_rg += 1
      remember = graph_rg[y][x]
      queue = deque([(x, y)])
      graph_rg[y][x] = 100
      while queue:
        cx, cy = queue.popleft()
        for i in range(4):
          nx, ny = cx + dx[i], cy + dy[i]
          if 0 <= nx < N and 0 <= ny < N and graph_rg[ny][nx] == remember:
            graph_rg[ny][nx] = 100
            queue.append((nx, ny))

print(count, count_rg)