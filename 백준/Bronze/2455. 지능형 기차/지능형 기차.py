import sys
input = sys.stdin.readline

train = 0
train_v = []

for i in range(4):
    out_p, in_p = map(int, input().split())
    train -= out_p
    train += in_p
    train_v.append(train)

print(max(train_v))

