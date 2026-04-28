import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
#[[선언하면 map이 나오고 [list만 괜찮은 이유
R_list = list(map(int, input().split()))

for i in R_list:
    if i == 1:
        M = len(graph[0])
        N = len(graph)
        for x in range(M):
            for y in range(N//2):
                graph[y][x], graph[N - y - 1][x] = graph[N - y - 1][x], graph[y][x]


    if i == 2:
        M = len(graph[0])
        N = len(graph)
        for y in range(N):
            for x in range(M//2):
                graph[y][x], graph[y][M-x-1] = graph[y][M-x-1], graph[y][x]

    if i == 3:
        M = len(graph[0])
        N = len(graph)
        new_graph = [[0 for _ in range(N)] for _ in range(M)]

        for y in range(N):
            for x in range(M):
                new_graph[x][N-y-1] = graph[y][x]
        graph = new_graph

    if i == 4:
        M = len(graph[0])
        N = len(graph)
        new_graph = [[0 for _ in range(N)] for _ in range(M)]

        for y in range(N):
            for x in range(M):
                new_graph[M-x-1][y] = graph[y][x]
        graph = new_graph

    if i == 5:
        M = len(graph[0])
        N = len(graph)
        new_graph = [[0 for _ in range(M)] for _ in range(N)]

        for y in range(N//2):
            for x in range(M//2):
                new_graph[y][x+(M//2)] = graph[y][x]

        for y in range(N//2):
            for x in range(M//2, M):
                new_graph[y+N//2][x] = graph[y][x]

        for y in range(N//2, N):
            for x in range(M//2, M):
                new_graph[y][x- M//2] = graph[y][x]

        for y in range(N//2, N):
            for x in range(M//2):
                new_graph[y - N//2][x] = graph[y][x]
        graph = new_graph

    if i == 6:
        M = len(graph[0])
        N = len(graph)
        new_graph = [[0 for _ in range(M)] for _ in range(N)]

        for y in range(N//2):
            for x in range(M//2):
                new_graph[y+N//2][x] = graph[y][x]

        for y in range(N//2):
            for x in range(M//2, M):
                new_graph[y][x- M//2] = graph[y][x]

        for y in range(N//2, N):
            for x in range(M//2, M):
                new_graph[y- N//2][x] = graph[y][x]

        for y in range(N//2, N):
            for x in range(M//2):
                new_graph[y][x+M//2] = graph[y][x]
        graph = new_graph

result = len(graph)

for i in range(result):
    print(*graph[i])