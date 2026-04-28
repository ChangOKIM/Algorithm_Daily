#백준 - 9093번
# 단어 뒤집기
from collections import deque
import sys

n = int(sys.stdin.readline().strip())

for i in range(n):
    sentence = sys.stdin.readline().strip().split()
    sen_rev = []

    for k in sentence:
        sen_rev.append("".join(reversed(k)))

    print(" ".join(sen_rev))
