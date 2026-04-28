import sys

def door(init):
  if init == 1:
    return ['*']
  stars = door(init//3)
  star_in = []

  for i in stars:
    star_in.append(i*3)
  for i in stars:
    star_in.append(i + ' '*(init//3)+i)
  for i in stars:
    star_in.append(i*3)
  return star_in
    



n = int(sys.stdin.readline().strip())
print('\n'.join(door(n)))