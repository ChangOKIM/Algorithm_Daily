import sys
input = sys.stdin.readline

def quad_tree(x, y, size):
    base = matrix[x][y]
    for i in range(x, x+size):
        for j in range(y, y+size):
            if matrix[i][j] != base:
                half = size // 2
                return "(" + \
                    quad_tree(x, y, half) + \
                    quad_tree(x, y + half, half) + \
                    quad_tree(x + half, y, half) + \
                    quad_tree(x + half, y + half, half) + ")"
    return str(base)

N = int(input())
matrix = [list(map(int, list(input().rstrip()))) for _ in range(N)]

print(quad_tree(0, 0, N))
