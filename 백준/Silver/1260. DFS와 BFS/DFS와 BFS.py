from collections import deque

n, m, v = map(int, input().split())

n_list = [list(map(int, input().split())) for _ in range(m)]

graph = [[] for _ in range(n+1)]

for a, b in n_list:
  graph[a].append(b)
  graph[b].append(a)

for i in graph:
  i.sort()

visited = [False] * (n+1)

dfs_result = []

def dfs(init):
  visited[init] = True
  dfs_result.append(init)

  for i in graph[init]:
    if not visited[i]:
      dfs(i)

dfs(v)
print(*dfs_result)


def bfs(init):
  visited = [False] * (n+1)
  visited[init] = True
  queue = deque([init])
  bfs_result = []
  
  while queue:
    check = queue.popleft()
    bfs_result.append(check)
    for i in graph[check]:
      if not visited[i]:
        visited[i] = True
        queue.append(i)
  print(*bfs_result)

bfs(v)