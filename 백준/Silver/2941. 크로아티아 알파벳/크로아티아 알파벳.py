import sys
input = sys.stdin.readline

s = list(map(str, input().strip()))

jump = 0
cnt = 0

for i in range(len(s)):
    if i + jump > len(s) -1:
        break
    if i + jump <= len(s) -2 and (s[i + jump] == 's' or s[i + jump] == 'z'):
        if s[i+1 + jump] == '=':
            cnt += 1
            jump += 1
        else:
            cnt +=1
    elif i + jump <= len(s) -2 and (s[i + jump] == 'c'):
        if s[i+1 + jump] == '-':
            cnt +=1
            jump +=1
        elif s[i+1 + jump] == '=':
            cnt +=1
            jump +=1
        else:
            cnt +=1
    elif i + jump <= len(s) -2 and (s[i + jump] == 'l' or s[i + jump] == 'n'):
        if s[i + 1 + jump] == 'j':
            cnt +=1
            jump +=1
        else:
            cnt +=1
    elif s[i + jump] == 'd':
        if i + jump <= len(s) -3 and s[i + 1 + jump]  == 'z' and s[i + 2 + jump] == '=':
            cnt +=1
            jump +=2
        elif i + jump <= len(s) -2 and s[i + 1 + jump] == '-':
            cnt +=1
            jump +=1
        else:
            cnt +=1
    else:
        cnt +=1

print(cnt)