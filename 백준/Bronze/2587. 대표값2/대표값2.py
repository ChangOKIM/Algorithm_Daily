import sys
input = sys.stdin.readline

l = []

for i in range(5):
    l.append(int(input()))
    
print(sum(l)//len(l))
l.sort()
print(l[2])