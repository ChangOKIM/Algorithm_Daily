def check_bingo(board):
  bingo_count = 0

  for row in board:
      if sum(row) == 0:
          bingo_count += 1

  for col in range(5):
      if sum(board[row][col] for row in range(5)) == 0:
          bingo_count += 1

  if sum(board[i][i] for i in range(5)) == 0:
      bingo_count += 1
  if sum(board[i][4 - i] for i in range(5)) == 0:
      bingo_count += 1

  return bingo_count

board = [list(map(int, input().split())) for _ in range(5)]
calls = [list(map(int, input().split())) for _ in range(5)]
calls = sum(calls, [])

for turn, number in enumerate(calls, start=1):
  for i in range(5):
      for j in range(5):
          if board[i][j] == number:
              board[i][j] = 0 

  if check_bingo(board) >= 3:
      print(turn)
      break