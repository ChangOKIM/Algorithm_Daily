import sys
sys.setrecursionlimit(10000)

t = int(input())

def dfs(node):
    visited[node] = True
    next_node = graph[node]
    if not visited[next_node]:
        dfs(next_node)

for _ in range(t):
    n = int(input())
    data = list(map(int, input().split()))
    graph = [0] + data
    visited = [False] * (n + 1)
    cycle_count = 0

    for i in range(1, n+1):
        if not visited[i]:
            dfs(i)
            cycle_count += 1

    print(cycle_count)