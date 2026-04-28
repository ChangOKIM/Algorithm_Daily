#백준 - 2407번
#nCm

n, m = map(int, input().split())

n_list = []
m_list = []

bunza = 1
bunmo = 1

for i in range(m):
  n_list.append(n-i)

for j in range(m):
  m_list.append(j+1)

for i in n_list:
  bunza *=i

for j in m_list:
  bunmo *= j

print(int(bunza//bunmo))