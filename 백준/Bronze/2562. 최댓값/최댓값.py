import sys

num_list = [0]

for i in range(9):
  num_list.append(int(sys.stdin.readline().strip()))


print(max(num_list))
print(num_list.index(max(num_list)))