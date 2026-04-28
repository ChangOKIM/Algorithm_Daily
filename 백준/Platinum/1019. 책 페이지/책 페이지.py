def count_pages(n):
  count = [0] * 10
  start, end, digit = 1, n, 1

  while start <= end:
      #1번(엔딩 처리)
      while end % 10 != 9 and start <= end:
          for c in str(end):
              count[int(c)] += digit
          end -= 1

      #2번(시작 처리)
      while start % 10 != 0 and start <= end:
          for c in str(start):
              count[int(c)] += digit
          start += 1

      if start > end:
          break

      #3번(나머지 규칙 있는 구간)
      block_count = (end // 10 - start // 10 + 1)
      for i in range(10):
          count[i] += block_count * digit

      #자리 올리기
      start //= 10
      end //= 10
      digit *= 10

  return count

N = int(input())
print(*count_pages(N))
