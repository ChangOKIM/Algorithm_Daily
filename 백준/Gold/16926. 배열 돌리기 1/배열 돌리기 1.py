import sys
input = sys.stdin.readline

#줄(세로), 가로(개수), 회전수
N, M, R = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

if N>M:
    for _ in range(R):
            paper = [[0 for i in range(M)] for i in range(N)]

            #왼쪽 아래로 내리는 계산(왼쪽 시작은 [0][1]따오기)
            for x in range(M//2):
                for y in range(x+1, N-x):
                    paper[y][x] = graph[y-1][x]


            #밑바닥(밑바닥 시작은 [끝][-1]따오기)
            for y in range(M//2):
                for x in range(y+1, M-y):
                    paper[N-y-1][x] = graph[N-y-1][x-1]


            #오른쪽 위로 올라가는 계산(시작은 바닥오른쪽꺼)
            for x in range(M//2):
                for y in range(x+1, N-x):
                    paper[N-y-1][M-x-1] = graph[N-y][M-x-1]

            for y in range(M//2):
                for x in range(y, M-1-y):
                    paper[y][x] = graph[y][x+1]

            graph = paper
    for i in range(N):
        print(*graph[i])
else:
    for _ in range(R):
            paper = [[0 for i in range(M)] for i in range(N)]

            #왼쪽 아래로 내리는 계산(왼쪽 시작은 [0][1]따오기)
            for x in range(N//2):
                for y in range(x+1, N-x):
                    paper[y][x] = graph[y-1][x]


            #밑바닥(밑바닥 시작은 [끝][-1]따오기)
            for y in range(N//2):
                for x in range(y+1, M-y):
                    paper[N-y-1][x] = graph[N-y-1][x-1]


            #오른쪽 위로 올라가는 계산(시작은 바닥오른쪽꺼)
            for x in range(N//2):
                for y in range(x+1, N-x):
                    paper[N-y-1][M-x-1] = graph[N-y][M-x-1]

            for y in range(N//2):
                for x in range(y, M-1-y):
                    paper[y][x] = graph[y][x+1]

            graph = paper

    for i in range(N):
        print(*graph[i])

