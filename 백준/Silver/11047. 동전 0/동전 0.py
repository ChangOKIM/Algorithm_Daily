n, k = map(int, input().split())
values = []
cnt = 0

for i in range(n):
  values.append(int(input()))

for j in range(n):
  if k // values[n-1-j] > 0:
    cnt += k // values[n-1-j]
    k = k % values[n-1-j]

print(cnt)