import sys
from collections import deque
input = sys.stdin.readline

def bfs(A, B):
    visited = bytearray(10000)
    from_num = [-1] * 10000
    how = [''] * 10000

    q = deque([A])
    visited[A] = 1

    while q:
        num = q.popleft()
        if num == B:
            break

        D = (num * 2) % 10000
        if not visited[D]:
            visited[D] = 1
            from_num[D] = num
            how[D] = 'D'
            q.append(D)

        S = num - 1 if num != 0 else 9999
        if not visited[S]:
            visited[S] = 1
            from_num[S] = num
            how[S] = 'S'
            q.append(S)

        L = (num % 1000) * 10 + num // 1000
        if not visited[L]:
            visited[L] = 1
            from_num[L] = num
            how[L] = 'L'
            q.append(L)

        R = (num % 10) * 1000 + num // 10
        if not visited[R]:
            visited[R] = 1
            from_num[R] = num
            how[R] = 'R'
            q.append(R)

    path = []
    cur = B
    while cur != A:
        path.append(how[cur])
        cur = from_num[cur]
    return ''.join(reversed(path))


T = int(input())
out = []
for _ in range(T):
    A, B = map(int, input().split())
    out.append(bfs(A, B))
print('\n'.join(out))
