n = int(input())

dp = [0 for _ in range(100001)]

dp[1] = 1

for i in range(2, 100001):
  if type(i**0.5) == int:
    dp[i] = 1
  else:
    min_val = 1e9
    for j in range(1, int(i**0.5)+1):
      min_val = min(min_val, dp[i-j**2])
    dp[i] = min_val + 1


print(dp[n])
