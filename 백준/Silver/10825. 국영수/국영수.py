n = int(input())

results = []

for _ in range(n):
  line = input().split()
  results.append([line[0]] + list(map(int, line[1:])))

results.sort(key = lambda x:(-x[1], x[2], -x[3], x[0]))

for i in range(n):
  print("".join(results[i][0]))