import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

friends = set(graph[1])
for f in graph[1]:
    for ff in graph[f]:
        friends.add(ff)

if 1 in friends:
    friends.remove(1)

print(len(friends))