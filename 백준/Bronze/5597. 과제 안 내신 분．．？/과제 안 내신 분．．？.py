import sys
input = sys.stdin.readline

class_list = [i for i in range(1, 31)]

for i in range(28):
    summit = int(input())

    class_list.remove(summit)

first = min(class_list)
print(first)
class_list.remove(first)
print(class_list[0])
