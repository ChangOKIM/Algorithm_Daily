import sys
sys.setrecursionlimit(10**6)

dx = [1, 0, -1, 0, 1, -1, -1, 1]
dy = [0, 1, 0, -1, 1, -1, 1, -1]

while True:
  w, h = map(int, input().split())
  if w == 0 and h == 0:
    break
  graph = [list(map(int, input().split())) for _ in range(h)]
  visited = [[False] * w for _ in range(h)]
  cnt = 0
  
  def dfs(y, x):
    visited[y][x] = True

    for i in range(8):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0<= nx < w and 0<= ny < h:
        if graph[ny][nx] == 1 and not visited[ny][nx]:
          visited[ny][nx] = True
          dfs(ny, nx)
  

  for y in range(h):
    for x in range(w):
      if graph[y][x] == 1 and not visited[y][x]:
        dfs(y, x)
        cnt += 1
  print(cnt)