n = int(input())

people = [tuple(map(int, input().split())) for _ in range(n)]

rank = [1] * n

for i in range(n):
    for j in range(n):
        if i == j:
            continue
        if people[j][0] > people[i][0] and people[j][1] > people[i][1]:
            rank[i] += 1

print(' '.join(map(str, rank)))