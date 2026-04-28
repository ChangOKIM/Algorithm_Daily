import sys
input = sys.stdin.readline

R, C, T = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(R)]

air_cleaner = []
for i in range(R):
    if room[i][0] == -1:
        air_cleaner.append(i)

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def spread():
    temp = [[0]*C for _ in range(R)]
    for x in range(R):
        for y in range(C):
            if room[x][y] > 0:
                val = room[x][y] // 5
                cnt = 0
                for d in range(4):
                    nx, ny = x+dx[d], y+dy[d]
                    if 0 <= nx < R and 0 <= ny < C and room[nx][ny] != -1:
                        temp[nx][ny] += val
                        cnt += 1
                temp[x][y] += room[x][y] - val*cnt
            elif room[x][y] == -1:
                temp[x][y] = -1
    return temp

def clean():
    top, bottom = air_cleaner

    # 위쪽 반시계
    for i in range(top-1,0,-1):
        room[i][0] = room[i-1][0]
    for j in range(C-1):
        room[0][j] = room[0][j+1]
    for i in range(top):
        room[i][C-1] = room[i+1][C-1]
    for j in range(C-1,1,-1):
        room[top][j] = room[top][j-1]
    room[top][1] = 0

    # 아래쪽 시계
    for i in range(bottom+1,R-1):
        room[i][0] = room[i+1][0]
    for j in range(C-1):
        room[R-1][j] = room[R-1][j+1]
    for i in range(R-1,bottom,-1):
        room[i][C-1] = room[i-1][C-1]
    for j in range(C-1,1,-1):
        room[bottom][j] = room[bottom][j-1]
    room[bottom][1] = 0

for _ in range(T):
    room = spread()
    clean()

answer = 0
for i in range(R):
    for j in range(C):
        if room[i][j] > 0:
            answer += room[i][j]
print(answer)