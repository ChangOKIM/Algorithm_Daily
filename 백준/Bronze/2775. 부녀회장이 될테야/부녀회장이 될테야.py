t = int(input())

for _ in range(t):
  k = int(input())
  n = int(input())

  dp = [[1 for _ in range(15)] for _ in range(k+1)]

  for i in range(15):
   dp[0][i] = i+1

  for i in range(1, k+1):
    for j in range(1, 15):
      dp[i][j] = dp[i][j-1] + dp[i-1][j]


  print(dp[k][n-1])

