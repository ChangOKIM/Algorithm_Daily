n = int(input())
n_list = []

for i in range(1, n+1):
  n_list.append(2*i + 1)

print(*n_list)
