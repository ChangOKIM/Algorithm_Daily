import sys
sys.setrecursionlimit(10000)

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

def dfs(x, target, dist, visited):
    if x == target:
        return dist
    visited[x] = True
    for nx, d in graph[x]:
        if not visited[nx]:
            res = dfs(nx, target, dist + d, visited)
            if res != -1:
                return res
    return -1

for _ in range(M):
    u, v = map(int, input().split())
    visited = [False] * (N+1)
    print(dfs(u, v, 0, visited))