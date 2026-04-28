from itertools import permutations

N = int(input())
questions = [list(map(int, input().split())) for _ in range(N)]

candidates = list(permutations(range(1, 10), 3))

def get_score(guess, target):
    strike = ball = 0
    for i in range(3):
        if guess[i] == target[i]:
            strike += 1
        elif guess[i] in target:
            ball += 1
    return strike, ball

count = 0

for candidate in candidates:
    is_possible = True
    for question in questions:
        q_num = list(map(int, str(question[0])))
        q_strike = question[1]
        q_ball = question[2]

        s, b = get_score(candidate, q_num)
        if s != q_strike or b != q_ball:
            is_possible = False
            break

    if is_possible:
        count += 1

print(count)
