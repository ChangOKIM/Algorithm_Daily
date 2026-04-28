#10757

import sys

def add(a, b):
    answer = a + b
    return answer

a, b = map(int, sys.stdin.readline().strip().split())

print(add(a, b))