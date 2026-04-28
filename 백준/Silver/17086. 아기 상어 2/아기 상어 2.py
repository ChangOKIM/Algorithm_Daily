from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

dx = [1, 0, -1, 0, 1, 1, -1, -1]
dy = [0, 1, 0, -1, 1, -1, 1, -1]

graph = [list(map(int, input().split())) for _ in range(n)]
safe_d = [0]
  
def bfs(x, y):
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[x][y] = True
    queue = deque([(x, y)])
    dist = 0

    while queue:
        for _ in range(len(queue)):
            cx, cy = queue.popleft()

            if graph[cx][cy] == 1:
                safe_d.append(dist)
                return

            for i in range(8):
                nx, ny = cx + dx[i], cy + dy[i]
                if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
        dist += 1

for x in range(n):
    for y in range(m):
        if graph[x][y] == 0:
            bfs(x, y)

print(max(safe_d))
