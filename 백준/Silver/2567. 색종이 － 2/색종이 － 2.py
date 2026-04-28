import sys
input = sys.stdin.readline

graph = [[0 for _ in range(100)] for _ in range(100)]

N = int(input())
cnt_h = 0
cnt_w = 0
for _ in range(N):
    W, H = map(int, input().split())
    for y in range(H,H+10):
        for x in range(W,W+10):
            graph[99-y][x] = 1

#세로로 쭉 내려와서 011이거나 110이면 세로cnt+=1

for y in 0,99:
    for x in range(100):
        if graph[y][x] == 1:
            cnt_w +=1
for x in 0,99:
    for y in range(100):
        if graph[y][x] == 1:
            cnt_h +=1
for y in range(100):
    for x in range(1,99):
        if (graph[y][x] == 1 and graph[y][x-1] == 0 and graph[y][x+1] == 1) or (graph[y][x] == 1 and graph[y][x-1] == 1 and graph[y][x+1] == 0):
            cnt_h +=1

for x in range(100):
    for y in range(1,99):
        if (graph[y][x] == 1 and graph[y-1][x] == 0 and graph[y+1][x] == 1) or (graph[y][x] == 1 and graph[y-1][x] == 1 and graph[y+1][x] == 0):
            cnt_w +=1

print(cnt_h + cnt_w)