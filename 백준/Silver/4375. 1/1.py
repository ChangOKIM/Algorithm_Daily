#백준 - 4375번

while True:
  try:
    n = int(input())
    first = 0
    cnt = []
    answer = []
    
    while(True):
      for i in range(0, 10):
        if (first + (n*i)) % 10 ==1:
          first = (first + (n*i)) // 10
          cnt.append(1)
          if first == 0:
            answer.append(sum(cnt))
      if len(answer) == 1:
        break
    
    print(answer[0])
  except EOFError:
    break