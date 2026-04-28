N, K, B = map(int, input().split())
broken_signals = set(int(input()) for _ in range(B))

# 처음 K개의 신호등을 검사하여 고장난 것을 count
current_broken_signals = sum(1 for i in range(1, K + 1) if i in broken_signals)

min_repairs = current_broken_signals  # 초기 설정

# 시작 위치를 1부터 N-K까지 이동하면서 수리 필요한 신호등을 갱신
for i in range(1, N - K + 1):
    current_broken_signals += int(i + K in broken_signals) - int(i in broken_signals)
    min_repairs = min(min_repairs, current_broken_signals)

print(min_repairs)