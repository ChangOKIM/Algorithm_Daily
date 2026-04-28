N = int(input())
dp = [0] * (N + 1)

dp[1] = 1
if N >= 2:
    dp[2] = 0

for i in range(3, N + 1):
    if dp[i-1] == 0 and dp[i-3] == 0:
        dp[i] = 1
    else:
        dp[i] = 0

print("SK" if dp[N] == 1 else "CY")