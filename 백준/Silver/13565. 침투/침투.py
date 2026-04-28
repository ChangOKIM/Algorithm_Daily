import sys
from collections import deque
input = sys.stdin.readline

M, N = map(int, input().split()) #M이 줄, [M][N]

graph = [list(map(int, input().strip())) for _ in range(M)]
visited = [[False for _ in range(N)] for _ in range(M)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
init = []

zzz = False

for i in range(N):
    if graph[0][i] == 0:
        init.append(i)


def bfs(x, y):
    queue = deque([])
    queue.append((x, y))
    visited[y][x] = True

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0<= nx < N and 0<= ny < M:
                if graph[ny][nx] == 0 and not visited[ny][nx]:
                    visited[ny][nx] = True
                    queue.append((nx, ny))

for i in init:
    bfs(i,0)

for i in range(N):
    if visited[-1][i]:
        zzz = True

if zzz:
    print("YES")
else:
    print("NO")
