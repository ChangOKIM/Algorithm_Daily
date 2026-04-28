import sys
input = sys.stdin.readline

# 8방향 (상,하,좌,우,대각선)
dx = [1, 0, -1, 0, 1, 1, -1, -1]
dy = [0, 1, 0, -1, 1, -1, 1, -1]

N, M, K = map(int, input().split())

# 각 칸의 나무들 (나이 리스트)
tree_graph = [[[] for _ in range(N)] for _ in range(N)]
# 현재 양분
init_power = [[5 for _ in range(N)] for _ in range(N)]
# 겨울에 추가되는 양분
Add_power = [list(map(int, input().split())) for _ in range(N)]

# 나무 정보 입력 (r, c, age)
for _ in range(M):
    r, c, age = map(int, input().split())
    tree_graph[r - 1][c - 1].append(age)

for _ in range(K):
    # --- 봄 + 여름 ---
    for y in range(N):
        for x in range(N):
            if not tree_graph[y][x]:
                continue

            tree_graph[y][x].sort()
            alive = []
            add_power = 0  # 여름에 더해질 양분 (죽은 나무의 나이//2)

            for age in tree_graph[y][x]:
                if init_power[y][x] >= age:
                    init_power[y][x] -= age
                    alive.append(age + 1)
                else:
                    add_power += age // 2

            tree_graph[y][x] = alive
            init_power[y][x] += add_power  # 여름 처리

    # --- 가을 ---
    for y in range(N):
        for x in range(N):
            if not tree_graph[y][x]:
                continue
            for age in tree_graph[y][x]:
                if age % 5 == 0:
                    for d in range(8):
                        ny = y + dy[d]
                        nx = x + dx[d]
                        if 0 <= ny < N and 0 <= nx < N:
                            tree_graph[ny][nx].append(1)

    # --- 겨울 ---
    for y in range(N):
        for x in range(N):
            init_power[y][x] += Add_power[y][x]

# K년 후 살아있는 나무 수
result = 0
for y in range(N):
    for x in range(N):
        result += len(tree_graph[y][x])

print(result)
