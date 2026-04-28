import sys
from collections import deque

input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

T = int(input())

for _ in range(T):
    w, h = map(int, input().split())
    graph = [list(input().strip()) for _ in range(h)]

    queue_f = deque()
    queue_h = deque()
    visited_fire = [[False] * w for _ in range(h)]
    visited_human = [[False] * w for _ in range(h)]

    for y in range(h):
        for x in range(w):
            if graph[y][x] == '*':
                queue_f.append((x, y))
                visited_fire[y][x] = True
            elif graph[y][x] == '@':
                queue_h.append((x, y))
                visited_human[y][x] = True


    escape = False
    time = 0

    while queue_h:
        time +=1

        for _ in range(len(queue_f)):
            fx, fy = queue_f.popleft()

            for i in range(4):
                nfx = fx + dx[i]
                nfy = fy + dy[i]

                if 0<= nfx < w and 0 <= nfy < h:
                    if not visited_fire[nfy][nfx] and (graph[nfy][nfx] == '.' or graph[nfy][nfx] == '@'):
                        visited_fire[nfy][nfx] = True
                        graph[nfy][nfx] = '*'
                        queue_f.append((nfx, nfy))

        for _ in range(len(queue_h)):
            x, y = queue_h.popleft()

            if x == 0 or x == w-1 or y == 0 or y == h-1:
                print(time)
                escape = True
                break

            for dir in range(4):
                nx = x + dx[dir]
                ny = y + dy[dir]

                if 0 <= nx < w and 0 <= ny < h:
                    if graph[ny][nx] == '.' and not visited_human[ny][nx] and graph[ny][nx] != '*':
                        visited_human[ny][nx] = True
                        queue_h.append((nx, ny))


        if escape:
            break
    if not escape:
        print("IMPOSSIBLE")
