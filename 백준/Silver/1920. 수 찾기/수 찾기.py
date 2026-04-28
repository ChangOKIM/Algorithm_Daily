import sys
input = sys.stdin.readline

n = int(input())
n_list = set(map(int, input().split()))

m = int(input())
m_list = list(map(int, input().split()))

for j in m_list:
    if j in n_list:
        sys.stdout.write('1\n')
    else:
        sys.stdout.write('0\n')
