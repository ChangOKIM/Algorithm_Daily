import sys

n = int(sys.stdin.readline().strip())

in_office = []

for i in range(n):
  check_io = list(map(str, sys.stdin.readline().strip().split()))
  if check_io[1] == 'enter':
    in_office.append(check_io[0])
  elif check_io[1] == 'leave':
    in_office.pop(in_office.index(check_io[0]))


in_office.sort(reverse=True)

for i in in_office:
  print(i)
