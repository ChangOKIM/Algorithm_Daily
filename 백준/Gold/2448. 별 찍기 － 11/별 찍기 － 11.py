import sys

def draw_star(n):
    if n == 3:
        return ["  *  ", " * * ", "*****"]

    stars = draw_star(n // 2)
    space = " " * (n // 2)

    top = [space + star + space for star in stars]
    bottom = [star + " " + star for star in stars]

    return top + bottom

n = int(sys.stdin.readline().strip())
print("\n".join(draw_star(n)))
