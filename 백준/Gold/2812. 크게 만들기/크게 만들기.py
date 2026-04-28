#2812번
#크게 만들기

import sys

n, k = map(int, sys.stdin.readline().strip().split())
num_list = list(map(int, sys.stdin.readline().strip()))

figures = n - k
max_num_stack = []

for i in range(n):
    while k > 0 and max_num_stack and max_num_stack[-1] < num_list[i]:
        max_num_stack.pop()
        k -= 1
    max_num_stack.append(num_list[i])


print(''.join(map(str, max_num_stack[:figures])))