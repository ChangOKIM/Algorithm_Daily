import sys
input = sys.stdin.readline

button = int(input())
button_list = list(map(int, input().split()))

students = int(input())
students_list = [list(map(int, input().split())) for _ in range(students)]

for sex, num in students_list:
    if sex == 1:
        times = len(button_list) // num
        for i in range(times):
            if button_list[(num-1) + num*i] == 0:
                button_list[(num-1) + num*i] = 1
            else:
                button_list[(num-1) + num*i] = 0
    else:
        avail = 0
        while True:
            if (num-1) - avail >= 0 and (num-1) + avail < len(button_list) and button_list[(num-1) - avail] == button_list[(num-1) + avail]:
                avail += 1
            else:
                break
        if avail == 1:
            if button_list[num-1] == 0:
                button_list[num-1] = 1
            else:
                button_list[num-1] = 0
        else:
            if button_list[num-1] == 0:
                button_list[num-1] = 1
            else:
                button_list[num-1] = 0

            for i in range(1, avail):
                if button_list[(num-1) - i] == 1:
                    button_list[(num-1) - i] = 0
                    button_list[(num-1) + i] =0

                elif button_list[(num-1) - i] == 0:
                    button_list[(num-1) - i] = 1
                    button_list[(num-1) + i] = 1 

if button <= 20:
    print(*button_list)
else:
    lines = button // 20
    lefft = button - 20*lines
    for i in range(lines):
        print(*button_list[20*i:20*(i+1)])
    if lefft != 0:
        print(*button_list[20*lines:])