import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())

n_list = [[] for _ in range(n+1)]
visited = [False for _ in range((n+1))]


for i in range(m):
  a, b = map(int, input().split())
  n_list[a].append(b)
  n_list[b].append(a)

def dfs(init):
  visited[init] = True

  for i in n_list[init]:
    if not visited[i]:
      dfs(i)

cnt = 0
for i in range(1, n+1):
  if not visited[i]:
    dfs(i)
    cnt +=1

print(cnt)

