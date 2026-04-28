#1427번

import sys

n = int(sys.stdin.readline().strip())

users = []

for i in range(n):
  users.append(sys.stdin.readline().strip().split())


for i in range(n):
  users[i].append(i)


users_asc = sorted(users, key=lambda x: (int(x[0]), x[2]))

for i in range(len(users)):
  print(users_asc[i][0], users_asc[i][1])