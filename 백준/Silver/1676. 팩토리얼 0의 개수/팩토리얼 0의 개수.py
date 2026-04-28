import sys

n = int(sys.stdin.readline().strip())
result = 1
cnt = 0

if n == 0 or n == 1:
  pass
else:
  for i in range(n, 1, -1):
    result *= i

result = str(result)

for i in range(len(result)-1, 0, -1):
  if result[i] == '0':
    cnt +=1
  else:
    break

print(cnt)