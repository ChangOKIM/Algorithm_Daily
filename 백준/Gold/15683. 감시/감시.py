n, m = map(int, input().split())
office = [list(map(int, input().split())) for _ in range(n)]
cctv = []
for i in range(n):
    for j in range(m):
        if 1 <= office[i][j] <= 5:
            cctv.append((i, j, office[i][j]))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
cctv_dir = {
    1: [[0], [1], [2], [3]],
    2: [[0, 2], [1, 3]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    5: [[0, 1, 2, 3]]
}

min_blind = int(1e9)

def fill(x, y, dirs, mark):
    changed = []
    for d in dirs:
        nx, ny = x, y
        while True:
            nx += dx[d]
            ny += dy[d]
            if not (0 <= nx < n and 0 <= ny < m):
                break
            if office[nx][ny] == 6:
                break
            if office[nx][ny] == 0:
                office[nx][ny] = mark
                changed.append((nx, ny))
    return changed

def dfs(idx):
    global min_blind
    if idx == len(cctv):
        blind = sum(row.count(0) for row in office)
        min_blind = min(min_blind, blind)
        return

    x, y, type = cctv[idx]
    for dirs in cctv_dir[type]:
        changed = fill(x, y, dirs, -1)
        dfs(idx + 1)
        for cx, cy in changed:
            office[cx][cy] = 0

dfs(0)
print(min_blind)