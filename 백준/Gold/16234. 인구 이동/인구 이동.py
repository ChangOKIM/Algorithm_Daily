import sys
from collections import deque
input = sys.stdin.readline

N, L, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y, move_avail):
    queue = deque([(x, y)])
    move_avail[y][x] = True

    union = [(x, y)]
    total = graph[y][x]

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not move_avail[ny][nx]:
                if L <= abs(graph[cy][cx] - graph[ny][nx]) <= R:
                    move_avail[ny][nx] = True
                    queue.append((nx, ny))
                    union.append((nx, ny))
                    total += graph[ny][nx]

    if len(union) > 1:
        new_val = total // len(union)
        for ux, uy in union:
            graph[uy][ux] = new_val
        return True
    return False


days = 0
while True:
    move_avail = [[False]*N for _ in range(N)]
    moved = False

    for y in range(N):
        for x in range(N):
            if not move_avail[y][x]:
                if bfs(x, y, move_avail):
                    moved = True

    if not moved:
        break
    days += 1

print(days)
