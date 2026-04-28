n, m, l = map(int, input().split())

seat = [0 for i in range(n)]

now_ball = 0
seat[0] = 1
times = 0 

while(max(seat) != m):
    if seat[now_ball] % 2 != 0:
        now_ball += l
        if now_ball > (n-1):
            now_ball = now_ball - n
        seat[now_ball] += 1
        times += 1
    else:
        now_ball -= l
        if now_ball < 0:
            now_ball = n + now_ball
        seat[now_ball] += 1
        times += 1
print(times)
