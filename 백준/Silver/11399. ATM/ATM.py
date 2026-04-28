n = int(input())

n_list = list(map(int, input().split()))
prefix = [0] * (n+1)

n_list.sort()

for i in range(1, n+1):
  prefix[i] = prefix[i-1] + n_list[i-1]

print(sum(prefix))