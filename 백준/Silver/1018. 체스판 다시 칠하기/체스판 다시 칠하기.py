n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

start_b = ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']
start_w = ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']

result = []

for i in range(m - 7):
    for j in range(n - 7):
        check_board = []
        for k in range(8):
            check_board.append(board[j + k][i:i + 8])

        cnt_b = 0
        cnt_w = 0

        for x in range(8):
            for y in range(8):
                expected_b = start_b[y] if x % 2 == 0 else start_w[y]
                expected_w = start_w[y] if x % 2 == 0 else start_b[y]

                if check_board[x][y] != expected_b:
                    cnt_b += 1
                if check_board[x][y] != expected_w:
                    cnt_w += 1

        result.append(min(cnt_b, cnt_w))

print(min(result))
