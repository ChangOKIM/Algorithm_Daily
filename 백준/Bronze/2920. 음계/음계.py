import sys

s = list(map(int, sys.stdin.readline().strip().split()))

sort_s = sorted(s)
reverse_s = list(reversed(sort_s))

if s == sort_s:
    print('ascending')
elif s == reverse_s:
    print('descending')
else:
    print('mixed')
        
