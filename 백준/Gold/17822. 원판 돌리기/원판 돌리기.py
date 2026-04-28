import sys
from collections import deque
input = sys.stdin.readline

N, M, T = map(int, input().split())
circles = []

for _ in range(N):
    circles.append(deque(map(int, input().split())))

for _ in range(T):
    x, d, k = map(int, input().split())

    #회전
    for r in range(len(circles)):
        if (r+1)%x == 0:
            if d == 0:
                for _ in range(k):
                    circles[r].rotate(1)
            elif d == 1:
                for _ in range(k):
                    circles[r].rotate(-1)

    #조건
    totals = 0
    #인접경우체크
    times = 0

    #인접정보저장
    same_check = [[False for _ in range(M)] for _ in range(N)]

    for i in range(N):
        totals += sum(circles[i])

    if totals == 0:
        break

    else:
        #원판내부, 인접원판 동시비교 안해도됨->정보저장덕분에
        #원판 내부먼저 0일떄,  M-1일떄, 나머지로 구분
        for i in range(N):
            for j in range(M):
                if j == 0:
                    if circles[i][j] == circles[i][1] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i][1] = True
                    if circles[i][j] == circles[i][-1] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i][-1] = True
                elif j == M-1:
                    if circles[i][j] == circles[i][0] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i][0] = True
                    if circles[i][j] == circles[i][M-2] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i][M-2] = True
                else:
                    if circles[i][j] == circles[i][j+1] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i][j+1] = True
                    if circles[i][j] == circles[i][j-1] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i][j-1] = True
        #이제 원판끼리 여부 체크
        #얘는 N이 0일떄, N-1일떄, 나머지로 구분
        for i in range(N):
            for j in range(M):
                if i == 0:
                    if circles[i][j] == circles[i+1][j] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i+1][j] = True
                elif i == N-1:
                    if circles[i][j] == circles[i-1][j] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i-1][j] = True
                else:
                    if circles[i][j] == circles[i+1][j] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i+1][j] = True
                    if circles[i][j] == circles[i-1][j] and circles[i][j] != 0:
                        same_check[i][j] = True
                        same_check[i-1][j] = True

        #이제 True있으면 제거하고 없으면 평균구해서 평균크냐작냐로 값재분배
        for i in range(N):
            for j in range(M):
                if same_check[i][j]:
                    times +=1

        if times == 0:
            nums = 0
            for i in range(N):
                for j in range(M):
                    if circles[i][j] > 0:
                        nums +=1

            avg = totals/nums
            for i in range(N):
                for j in range(M):
                    if circles[i][j] > avg and circles[i][j] != 0:
                        circles[i][j] -=1
                    elif circles[i][j] < avg and circles[i][j] != 0:
                        circles[i][j] +=1
        else:
            for i in range(N):
                for j in range(M):
                    if same_check[i][j]:
                        circles[i][j] = 0

result = 0
for i in range(N):
    result += sum(circles[i])

print(result)




