import sys

input = sys.stdin.readline

N, M = map(int, input().split())

N_list = list(i for i in range(1, N + 1))

for _ in range(M):
    i, j = map(int, input().split())
    if j == i:
        continue
    elif j - i == 1:
        N_list[j - 1], N_list[i - 1] = N_list[i - 1], N_list[j - 1]
    else:
        times = j-i

        for k in range((times+1)//2):
            N_list[j-1-k], N_list[i-1+k] = N_list[i-1+k], N_list[j-1-k]
print(*N_list)

