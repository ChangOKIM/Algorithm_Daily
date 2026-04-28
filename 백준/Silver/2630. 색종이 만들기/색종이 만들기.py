import sys

def all_wb(paper):
    first = paper[0][0]
    for row in paper:
        if any(cell != first for cell in row):
            return None
    return first

def divide_and_count(x, y, size):
    global white, blue
    check = all_wb([row[y:y+size] for row in paper[x:x+size]])

    if check is not None:
        if check == 0:
            white += 1
        else:
            blue += 1
        return

    half = size // 2
    divide_and_count(x, y, half)
    divide_and_count(x, y + half, half)
    divide_and_count(x + half, y, half)
    divide_and_count(x + half, y + half, half)

n = int(sys.stdin.readline().strip())

paper = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

white, blue = 0, 0 
divide_and_count(0, 0, n)

print(white)
print(blue)
