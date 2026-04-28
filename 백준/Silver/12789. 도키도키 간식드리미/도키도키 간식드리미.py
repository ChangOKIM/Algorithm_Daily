import sys
from collections import deque

n = int(sys.stdin.readline())
student_list = deque(map(int, sys.stdin.readline().split()))

standby_list = []
taken_list = []

order = 1  # 간식 받을 차례 번호

while student_list:
    if student_list[0] == order:
        a = student_list.popleft()
        taken_list.append(a)
        order += 1
    else:
        if standby_list and standby_list[-1] == order:
            b = standby_list.pop()
            taken_list.append(b)
            order += 1
        else:
            c = student_list.popleft()
            standby_list.append(c)

# 남은 standby_list 처리
while standby_list:
    if standby_list[-1] == order:
        d = standby_list.pop()
        taken_list.append(d)
        order += 1
    else:
        break

if order == n + 1:
    print("Nice")
else:
    print("Sad")
