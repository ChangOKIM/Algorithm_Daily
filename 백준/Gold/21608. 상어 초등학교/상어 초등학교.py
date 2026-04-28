import sys

input = sys.stdin.readline

N = int(input())

order = []

likes = dict()

for _ in range(N * N):

    a, b, c, d, e = map(int, input().split())

    order.append(a)

    likes[a] = {b, c, d, e}

# 교실: 0은 빈자리

room = [[0] * N for _ in range(N)]

dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def in_range(x, y):

    return 0 <= x < N and 0 <= y < N

for stu in order:

    best = None  # ( -like_cnt, -empty_cnt, r, c )

    best_pos = None

    for r in range(N):

        for c in range(N):

            if room[r][c] != 0:

                continue

            like_cnt = 0

            empty_cnt = 0

            for dx, dy in dirs:

                nr, nc = r + dx, c + dy

                if not in_range(nr, nc):

                    continue

                if room[nr][nc] == 0:

                    empty_cnt += 1

                elif room[nr][nc] in likes[stu]:

                    like_cnt += 1

            key = (-like_cnt, -empty_cnt, r, c)

            if best is None or key < best:

                best = key

                best_pos = (r, c)

    r, c = best_pos

    room[r][c] = stu

# 만족도 계산

score_map = {0: 0, 1: 1, 2: 10, 3: 100, 4: 1000}

answer = 0

for r in range(N):

    for c in range(N):

        stu = room[r][c]

        like_cnt = 0

        for dx, dy in dirs:

            nr, nc = r + dx, c + dy

            if in_range(nr, nc) and room[nr][nc] in likes[stu]:

                like_cnt += 1

        answer += score_map[like_cnt]

print(answer)