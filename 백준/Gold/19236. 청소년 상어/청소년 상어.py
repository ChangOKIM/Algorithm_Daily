import copy

import sys

input = sys.stdin.readline

# 방향 (↑, ↖, ←, ↙, ↓, ↘, →, ↗)

dx = [-1, -1, 0, 1, 1, 1, 0, -1]

dy = [0, -1, -1, -1, 0, 1, 1, 1]

def move_fish(board, fishes, shark_x, shark_y):

    for i in range(1, 17):

        if fishes[i] == []:  # 이미 먹힌 물고기

            continue

        x, y, d = fishes[i]

        for _ in range(8):  # 최대 8번 회전

            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < 4 and 0 <= ny < 4 and not (nx == shark_x and ny == shark_y):

                if board[nx][ny] != 0:

                    swap_fish = board[nx][ny]

                    fishes[i] = [nx, ny, d]

                    fishes[swap_fish][0], fishes[swap_fish][1] = x, y

                    board[x][y], board[nx][ny] = swap_fish, i

                else:  # 빈 칸

                    fishes[i] = [nx, ny, d]

                    board[x][y], board[nx][ny] = 0, i

                break

            d = (d + 1) % 8

        fishes[i][2] = d

def dfs(board, fishes, shark_x, shark_y, shark_d, total):

    global answer

    answer = max(answer, total)

    # 물고기 이동

    move_fish(board, fishes, shark_x, shark_y)

    # 상어 이동 (1~3칸)

    for step in range(1, 4):

        nx, ny = shark_x + dx[shark_d]*step, shark_y + dy[shark_d]*step

        if 0 <= nx < 4 and 0 <= ny < 4 and board[nx][ny] != 0:

            new_board = copy.deepcopy(board)

            new_fishes = copy.deepcopy(fishes)

            fish_num = new_board[nx][ny]

            nd = new_fishes[fish_num][2]

            new_board[shark_x][shark_y] = 0

            new_board[nx][ny] = -1

            new_fishes[fish_num] = []

            dfs(new_board, new_fishes, nx, ny, nd, total + fish_num)

# 입력 처리

board = [[0]*4 for _ in range(4)]

fishes = [[] for _ in range(17)]

for i in range(4):

    data = list(map(int, input().split()))

    for j in range(4):

        fish_num, d = data[2*j], data[2*j+1] - 1

        board[i][j] = fish_num

        fishes[fish_num] = [i, j, d]

first_fish = board[0][0]

shark_d = fishes[first_fish][2]

fishes[first_fish] = []

board[0][0] = -1

answer = 0

dfs(board, fishes, 0, 0, shark_d, first_fish)

print(answer)