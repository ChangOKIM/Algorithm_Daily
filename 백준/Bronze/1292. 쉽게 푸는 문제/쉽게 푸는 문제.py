#백준 - 1292번

a, b = map(int, input().split())

total_list = []
sum = 0


for i in range(1, 46):
  for j in range(1, i+1):
    total_list.append(i)

for k in range(a, b+1):
  sum += total_list[k-1]

print(sum)