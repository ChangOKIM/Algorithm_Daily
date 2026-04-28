import sys

n = int(sys.stdin.readline().strip())
dp = []

for i in range(n):
    line = list(map(int, sys.stdin.readline().strip().split()))

    if i == 0:
        dp.append(line)
    else:
        temp = []
        for j in range(len(line)):
            if j == 0:
                temp.append(dp[i-1][0] + line[j])
            elif j == i:
                temp.append(dp[i-1][-1] + line[j])
            else:
                temp.append(max(dp[i-1][j-1], dp[i-1][j]) + line[j])
        dp.append(temp)

print(max(dp[-1]))
