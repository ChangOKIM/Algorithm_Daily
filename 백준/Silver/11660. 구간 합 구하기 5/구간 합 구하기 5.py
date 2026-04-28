#백준11660

import sys

n, m = map(int, sys.stdin.readline().strip().split())
matrix = []

for i in range(n):
    lines = list(map(int, sys.stdin.readline().strip().split()))
    prefix_lines = [0]*(n+1)
    for i in range(len(lines)):
        prefix_lines[i+1] = lines[i] + prefix_lines[i]
    matrix.append(prefix_lines)


for i in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().strip().split())
    if x1 == x2:
        if y1 == y2:
            answer = matrix[x1-1][y1] - matrix[x1-1][y1-1]
        else:
            answer = matrix[x1-1][y2] - matrix[x1-1][y1-1]
    else:
        front = matrix[x1-1][y2] - matrix[x1-1][y1-1]
        tail = matrix[x2-1][y2] - matrix[x2-1][y1-1]
        sum = 0
        for j in range(x1, x2-1):
            sum += matrix[j][y2] - matrix[j][y1-1]
        answer = sum + front + tail
    print(answer)