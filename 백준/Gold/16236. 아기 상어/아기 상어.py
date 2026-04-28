import sys

from collections import deque

input = sys.stdin.readline

# 방향: 상, 좌, 우, 하 (거리 동률일 때 '위, 왼쪽' 우선 선택에 유리하게 탐색순서 설계)

dy = [-1, 0, 0, 1]

dx = [0, -1, 1, 0]

def bfs(start_y, start_x, size, board, n):

    """현재 위치에서 이동 가능 칸(<= size)으로 BFS, 먹을 수 있는 물고기(< size) 후보 수집."""

    dist = [[-1]*n for _ in range(n)]

    q = deque()

    q.append((start_y, start_x))

    dist[start_y][start_x] = 0

    candidates = []  # (거리, y, x)

    while q:

        y, x = q.popleft()

        for i in range(4):

            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < n and 0 <= nx < n and dist[ny][nx] == -1:

                # size 이하로만 지나갈 수 있음

                if board[ny][nx] <= size:

                    dist[ny][nx] = dist[y][x] + 1

                    q.append((ny, nx))

                    # 0은 빈칸, size는 같은 크기 물고기(지나갈 수만 있음), 1~(size-1)은 먹을 수 있음

                    if 0 < board[ny][nx] < size:

                        candidates.append((dist[ny][nx], ny, nx))

    if not candidates:

        return None  # 더 이상 먹을 수 있는 물고기 없음

    candidates.sort()  # 거리, y, x 순으로 자동 정렬

    return candidates[0]  # (dist, y, x)

def main():

    n = int(input().strip())

    board = [list(map(int, input().split())) for _ in range(n)]

    # 상어 초기 위치, 크기/먹은 수, 경과 시간

    sy = sx = -1

    for y in range(n):

        for x in range(n):

            if board[y][x] == 9:

                sy, sx = y, x

                board[y][x] = 0  # 빈칸으로 바꿔둠

                break

        if sy != -1:

            break

    size = 2

    eaten = 0

    elapsed = 0

    while True:

        found = bfs(sy, sx, size, board, n)

        if found is None:

            print(elapsed)

            return

        dist, ny, nx = found

        elapsed += dist

        eaten += 1

        board[ny][nx] = 0

        sy, sx = ny, nx

        if eaten == size:

            size += 1

            eaten = 0

if __name__ == "__main__":

    main()