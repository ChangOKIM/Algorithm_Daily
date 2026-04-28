import sys
input = sys.stdin.readline

N, L = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

def ok(line):
    used = [False] * N  # 경사로 설치 여부
    for i in range(N - 1):
        h, nh = line[i], line[i + 1]
        diff = nh - h

        if diff == 0:
            continue

        # 오르막 (현재 h에서 다음 nh = h+1)
        if diff == 1:
            # 바로 직전 칸들(i, i-1, ..., i-L+1)이 모두 높이 h이고 미사용이어야
            for k in range(i, i - L, -1):
                if k < 0 or line[k] != h or used[k]:
                    return False
            for k in range(i, i - L, -1):
                used[k] = True

        # 내리막 (현재 h에서 다음 nh = h-1)
        elif diff == -1:
            # 앞으로 칸들(i+1, i+2, ..., i+L)이 모두 높이 nh이고 미사용이어야
            for k in range(i + 1, i + 1 + L):
                if k >= N or line[k] != nh or used[k]:
                    return False
            for k in range(i + 1, i + 1 + L):
                used[k] = True

        else:
            # 높이 차이가 2 이상이면 불가
            return False

    return True

ans = 0
# 가로
for r in range(N):
    if ok(board[r]):
        ans += 1

# 세로
for c in range(N):
    col = [board[r][c] for r in range(N)]
    if ok(col):
        ans += 1

print(ans)
