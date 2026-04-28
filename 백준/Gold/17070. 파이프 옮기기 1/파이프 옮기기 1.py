import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

dp = [[[0]*3 for _ in range(N)] for __ in range(N)]

dp[0][1][0] = 1 if board[0][0] == 0 and board[0][1] == 0 else 0

for r in range(N):
    for c in range(2, N):
        if board[r][c] == 1:
            continue

        dp[r][c][0] += dp[r][c-1][0] + dp[r][c-1][2]

        if r - 1 >= 0:
            dp[r][c][1] += dp[r-1][c][1] + dp[r-1][c][2]

        if r - 1 >= 0 and board[r-1][c] == 0 and board[r][c-1] == 0:
            dp[r][c][2] += dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2]

print(sum(dp[N-1][N-1]))
