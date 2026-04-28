#백준 - 11866번
# 요세푸스
import sys

n, k = map(int, sys.stdin.readline().strip().split())

number_li = list(range(1, n+1)) 
output = []
check_point = 0

while number_li:
    check_point = (check_point + k - 1) % len(number_li)
    output.append(number_li.pop(check_point))

print("<" + ", ".join(map(str, output)) + ">")

