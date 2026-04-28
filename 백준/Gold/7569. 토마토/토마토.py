from collections import deque

m, n, h = map(int, input().split())

graph = [[[0 for _ in range(m)]for _ in range(n)]for _ in range(h)]

for i in range(h):
  for j in range(n):
    n_list = list(map(int, input().split()))
    for k in range(len(n_list)):
      graph[i][j][k] = n_list[k]

dx = [1, 0, -1, 0, 0, 0]
dy = [0, -1, 0, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

def bfs():
  queue = deque()

  for z in range(h):
    for y in range(n):
      for x in range(m):
        if graph[z][y][x] == 1:
          queue.append([z, y, x])
  
  while queue:
    cz, cy, cx = queue.popleft()
    for i in range(6):
      nz = cz + dz[i]
      ny = cy + dy[i]
      nx = cx + dx[i]

      if 0<= nz < h and 0<= ny <n and 0<= nx <m:
        if graph[nz][ny][nx] == 0:
          graph[nz][ny][nx] = graph[cz][cy][cx] + 1
          queue.append([nz, ny, nx])

bfs()
result = 0

for z in range(h):
  for y in range(n):
    for x in range(m):
      if graph[z][y][x] == 0:
        print(-1)
        exit()
      result = max(result, graph[z][y][x])

print(result - 1)



