import sys

input = sys.stdin.readline

test_case_count = int(input())

for _ in range(test_case_count):
    column_count = int(input())

    sticker_scores = []
    for _ in range(2):
        sticker_scores.append(list(map(int, input().split())))

    if column_count == 1:
        print(max(sticker_scores[0][0], sticker_scores[1][0]))
        continue

    max_score = [[0] * column_count for _ in range(2)]

    max_score[0][0] = sticker_scores[0][0]
    max_score[1][0] = sticker_scores[1][0]

    max_score[0][1] = max_score[1][0] + sticker_scores[0][1]
    max_score[1][1] = max_score[0][0] + sticker_scores[1][1]

    for col in range(2, column_count):
        max_score[0][col] = max(max_score[1][col-1], max_score[1][col-2]) + sticker_scores[0][col]
        max_score[1][col] = max(max_score[0][col-1], max_score[0][col-2]) + sticker_scores[1][col]

    print(max(max_score[0][column_count-1], max_score[1][column_count-1]))
