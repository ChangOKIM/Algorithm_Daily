import sys
from collections import deque

input = sys.stdin.readline
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
min_val = 101
max_val = 0

N = int(input())

graph = list(list(map(int, input().split()))for _ in range(N))

visited = [[False for _ in range(N)] for _ in range(N)]

for i in range(N):
  min_val = min(min(graph[i]), min_val)
  max_val = max(max(graph[i]), max_val)


avail = []

for check in range(min_val-1, max_val+1):
  area_cnt = 0
  for y in range(N):
    for x in range(N):
      if graph[y][x] > check and not visited[y][x]:
        area_cnt +=1
        queue = deque([(x, y)])
        visited[y][x] = True
      
        while queue:
          cx, cy = queue.popleft()
          for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0<= nx < N and 0<= ny < N:
              if graph[ny][nx] > check and not visited[ny][nx]:
                queue.append((nx, ny))
                visited[ny][nx] = True
    
  avail.append(area_cnt)
  for i in range(N):
    for j in range(N):
      visited[i][j] = False

print(max(avail))
