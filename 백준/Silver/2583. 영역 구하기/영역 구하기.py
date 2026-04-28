import sys
sys.setrecursionlimit(10000)
m, n, k = map(int, input().split())
graph = [[0]*n for _ in range(m)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1

def dfs(x, y):
    global count
    if x < 0 or x >= m or y < 0 or y >= n:
        return
    if graph[x][y] == 1:
        return
    graph[x][y] = 1

    count += 1

    dfs(x-1, y)
    dfs(x+1, y)
    dfs(x, y-1)
    dfs(x, y+1)

result = []

for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            count = 0
            dfs(i, j)
            result.append(count)

result.sort()
print(len(result))
print(' '.join(map(str, result)))