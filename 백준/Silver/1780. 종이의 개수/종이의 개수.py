import sys
input = sys.stdin.readline

def check_paper(x, y, size):
    base = paper[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if paper[i][j] != base:
                return False
    return True

def divide(x, y, size):
    if check_paper(x, y, size):
        counts[paper[x][y]] += 1
        return
    new_size = size // 3
    for i in range(3):
        for j in range(3):
            divide(x + i * new_size, y + j * new_size, new_size)

N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
counts = {-1:0, 0:0, 1:0}

divide(0, 0, N)

print(counts[-1])
print(counts[0])
print(counts[1])
