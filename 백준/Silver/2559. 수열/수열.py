import sys
input = sys.stdin.readline

n, k = map(int, input().split())

tem = list(map(int, input().split()))

s = []
s.append(sum(tem[:k]))

for i in range(n-k):
  s.append(s[i] - tem[i] + tem[k+i])

print(max(s))