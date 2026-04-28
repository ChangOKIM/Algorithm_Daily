#백준 2023번
#신기한 소수 n자리까지 모두 소수인 것 출력
#스스로 못 푼 문제

n=int(input())


def isPrime(a):
    if(a<2):
        return False
    for i in range(2,int(a**0.5)+1):
        if(a%i==0):
            return False
    return True

def dfs(num):
    if len(str(num))==n:
        print(num)
    else:
        for i in range(10):
            temp=num*10+i
            if isPrime(temp):
                dfs(temp)

dfs(2)
dfs(3)
dfs(5)
dfs(7)