import heapq

n = int(input())
graph = [list(map(int, input())) for _ in range(n)]
dist = [[float('inf')] * n for _ in range(n)]

moves = [(1,0), (0,1), (-1,0), (0,-1)]

def dijkstra():
    hq = []
    heapq.heappush(hq, (0, 0, 0))
    dist[0][0] = 0

    while hq:
        cost, x, y = heapq.heappop(hq)
        if dist[y][x] < cost:
            continue

        for dx, dy in moves:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n:
                new_cost = cost + (graph[ny][nx] == 0)
                if new_cost < dist[ny][nx]:
                    dist[ny][nx] = new_cost
                    heapq.heappush(hq, (new_cost, nx, ny))

dijkstra()
print(dist[n-1][n-1])