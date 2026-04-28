k = int(input())

nums = [i for i in range(10)]

sign = list(map(str, input().split()))

visited = [False] * 10

result = []

final = []

def dfs(init, depth):
  if len(result) == k+1:
    final.append("".join(map(str, result)))
    return

  for i in range(10):
    if not visited[i]:
      if sign[depth] == '<' and init < i:
        visited[i] = True
        result.append(i)
        dfs(i, depth + 1)
        visited[i] = False
        result.pop()
        
      elif sign[depth] == '>' and init > i:
        visited[i] = True
        result.append(i)
        dfs(i, depth + 1)
        visited[i] = False
        result.pop()

for i in range(10):
  visited[i] = True
  result.append(i)
  dfs(i, 0)
  visited[i] = False
  result.pop()

print(final[-1])
print(final[0])