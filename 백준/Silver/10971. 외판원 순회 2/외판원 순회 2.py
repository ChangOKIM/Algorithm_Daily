import sys
input = sys.stdin.readline

N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]

INF = 10**12
visited = [False] * N
best = INF

def dfs(cur, depth, cost, start):
    global best
    # 현재까지가 이미 최적해보다 크면 가지치기
    if cost >= best:
        return
    if depth == N:
        if W[cur][start] != 0:
            best = min(best, cost + W[cur][start])
        return
    for nxt in range(N):
        if visited[nxt] or W[cur][nxt] == 0:
            continue
        visited[nxt] = True
        dfs(nxt, depth + 1, cost + W[cur][nxt], start)
        visited[nxt] = False

visited[0] = True
dfs(0, 1, 0, 0)
print(best)
