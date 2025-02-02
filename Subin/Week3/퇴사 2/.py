import sys
input = sys.stdin.readline #빠른 입출력을 써야함!

N = int(input())
T = []
P=[]
for _ in range(N):
    a,b = map (int, input().split())
    T.append(a)
    P.append(b)
dp = [0]*(N+1) #다음날꺼까지 계산하기 때문에 크기 N+1개만큼 만들어야함 

for i in range(N):
    if i + T[i]<=N:
        dp[i+ T[i]] = max(dp[i+ T[i]], dp[i]+P[i])
    dp[i+1] = max(dp[i+1],dp[i]) #다음날꺼 계산 -> 다음날 비교해서 다음날 최대 페이 계산함

print (max(dp))
