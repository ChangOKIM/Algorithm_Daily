import sys

input = sys.stdin.readline

n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

s_graph = sorted(graph, key= lambda x:(x[1], x[0]))

for i in s_graph:
     print(*i)