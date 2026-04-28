import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

visited = [[False for _ in range(m)] for _ in range(n)]

graph_cnt = [[0 for _ in range(m)] for _ in range(n)]


dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]



def dfs(y, x):
  visited[y][x] = True
  cnt[0] +=1

  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<= nx <m and 0<= ny <n:
      if graph[ny][nx] == 1 and not visited[ny][nx]:
        visited[ny][nx] = True
        dfs(ny, nx)

area_max = []
times = 0
for y in range(n):
  for x in range(m):
    if graph[y][x] >0 and not visited[y][x]:
      cnt = [0]
      times +=1
      dfs(y, x)
      area_max.append(cnt[0])

print(times)
if len(area_max) == 0:
  print(0)
else:
  print(max(area_max))