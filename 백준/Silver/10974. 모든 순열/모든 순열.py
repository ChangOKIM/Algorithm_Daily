from itertools import permutations

n = int(input())
bowl = []

for i in range(n):
    bowl.append(i+1)


tnsduf = list(permutations(bowl, n))

for j in tnsduf:
    print(*j)
