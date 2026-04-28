import sys

n = int(sys.stdin.readline())

stack_list = []
asc_list = []
result = []
cnt = 0
error = 0

for i in range(n):
    stack_list.append(int(sys.stdin.readline()))

for j in range(len(stack_list)):
    if len(asc_list)==0:
        for i in range(cnt, stack_list[j]):
            asc_list.append(i+1)
            cnt +=1
            result.append('+')
        asc_list.pop()
        result.append('-')
    else:
        if asc_list[-1] == stack_list[j]:
            asc_list.pop()
            result.append('-')
        elif asc_list[-1] < stack_list[j]:
            for k in range(cnt+1, int(stack_list[j])+1):
                asc_list.append(k)
                cnt +=1
                result.append('+')
            asc_list.pop()
            result.append('-')
        else:
            error +=1
            
if error != 0:
    print('NO')
else:
    for i in result:
        print(i)
            