import sys
import copy
from itertools import combinations
from collections import deque

input = sys.stdin.readline

N, M, D = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
graph.append([0] * M)          # 성 위치 (궁수 바로 위 한 줄 더)
graph = deque(graph)

combi = [i for i in range(M)]
arrow = list(combinations(combi, 3))
killed = []

# 초기 적 개수
enomy_init = 0
for y in range(N):
    for x in range(M):
        if graph[y][x] == 1:
            enomy_init += 1

for a, b, c in arrow:
    check_list = [a, b, c]
    graph_cp = copy.deepcopy(graph)

    att_cnt = 0
    enomy = enomy_init

    while enomy != 0:
        # 이번 턴에 세 궁수가 쏠 목표들 (동시에 공격해야 해서 모아둠)
        targets = set()

        # 궁수 하나씩 처리
        for i in check_list:
            min_dist = D + 1
            tx, ty = -1, -1

            # 모든 적을 보면서 가장 가까운 + 가장 왼쪽 선택
            for y in range(N):
                for x in range(M):
                    if graph_cp[y][x] == 1:
                        dist = abs(N - y) + abs(i - x)
                        if dist <= D:
                            if dist < min_dist or (dist == min_dist and x < tx):
                                min_dist = dist
                                tx, ty = x, y

            if tx != -1:
                targets.add((ty, tx))

        # 세 궁수가 고른 타겟을 동시에 제거
        for ty, tx in targets:
            if graph_cp[ty][tx] == 1:
                graph_cp[ty][tx] = 0
                att_cnt += 1

        # 적 한 칸 아래로 이동 (rotate 후 맨 아래 줄 비우기)
        graph_cp.rotate(1)
        for i in range(M):
            graph_cp[-1][i] = 0

        # 남은 적 개수 다시 세기
        en_cnt = 0
        for y in range(N):
            for x in range(M):
                if graph_cp[y][x] == 1:
                    en_cnt += 1
        enomy = en_cnt

    killed.append(att_cnt)

print(max(killed))
