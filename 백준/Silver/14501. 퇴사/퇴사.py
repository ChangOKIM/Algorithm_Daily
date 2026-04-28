n = int(input())
consulting = [list(map(int, input().split())) for _ in range(n)]

max_box = [0] * (n + 1)

for i in range(n - 1, -1, -1):
    time, pay = consulting[i]
    end_day = i + time

    if end_day <= n:
        max_box[i] = max(max_box[i + 1], pay + max_box[end_day])
    else:
        max_box[i] = max_box[i + 1]

print(max_box[0])