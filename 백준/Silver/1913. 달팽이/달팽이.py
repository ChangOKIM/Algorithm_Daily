n = int(input())

find_n = int(input())

mtx = [list(0 for _ in range(n)) for _ in range(n)]
cnt = [0] * 4
max_val = n * n

total_line = 2*n - 1


for i in range(total_line):
    if (i+1) % 4 == 1:
        for j in range(cnt[3], n - cnt[1]):
            mtx[j][cnt[3]] = max_val
            max_val -= 1
        cnt[0] += 1
    elif (i+1) % 4 == 2:
        for j in range(cnt[0], n - cnt[2]):
            mtx[n - cnt[0]][j] = max_val
            max_val -=1
        cnt[1] += 1
    elif (i+1) % 4 == 3:
        for j in range(cnt[3], n - cnt[1]):
            mtx[n-j-2][n - cnt[1]] = max_val
            max_val -= 1
        cnt[2] += 1
    elif (i+1) % 4 == 0:
        for j in range(cnt[0], n - cnt[2]):
            mtx[cnt[2] - 1][n-j-1] = max_val
            max_val -= 1
        cnt[3] += 1

for i in range(len(mtx)):
    for j in range(len(mtx)):
        print(mtx[i][j], end = ' ')
    print()

x_cnt = 0
y_cnt = 0

for i in range(n):
    y_cnt +=1
    for j in range(n):
        x_cnt +=1
        if mtx[i][j] == find_n:
            print(y_cnt, x_cnt - (y_cnt-1)*n)
            break

