N, X = map(int, input().split())
visitors = list(map(int, input().split()))

current = sum(visitors[:X])
max_sum = current
count = 1

for i in range(X, N):

    current += visitors[i] - visitors[i - X]
    if current > max_sum:
        max_sum = current
        count = 1
    elif current == max_sum:
        count += 1

if max_sum == 0:
    print("SAD")
else:
    print(max_sum)
    print(count)