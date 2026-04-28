import sys

def is_balanced_string(line):
    stack = []
    for char in line:
        if char == '(' or char == '[':
            stack.append(char)
        elif char == ')':
            if not stack or stack[-1] != '(':
                return "no"
            stack.pop()
        elif char == ']':
            if not stack or stack[-1] != '[':
                return "no"
            stack.pop()

    return "yes" if not stack else "no"

def is_balanced():
    while True:
        line = sys.stdin.readline().rstrip()
        if line == ".":
            break
        print(is_balanced_string(line))

is_balanced()
