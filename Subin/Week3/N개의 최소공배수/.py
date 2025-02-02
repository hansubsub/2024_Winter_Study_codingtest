import math
def lcm(a,b):
    return a*b // math. gcd(a,b) #최소 공배수 구함

def solution(arr): #(0,1 의 최소공배수)와 2의 최소 공배수
    result = arr[0]
    for i in range(len(arr)-1):
        cal = lcm(result,arr[i+1])
        result = cal
    return result





#처음 시도한 코드 반례 :  [12, 18] -> 36
#코드를 어떻게 바꾸면 반례 없이 정답 코드가 되는지 고민중...
def solution(arr):
    if 0 in arr:
        result = 0
        
    else:
        result = 1
        arr.sort(reverse =True) #내림차순 정렬
        for i in arr:
            result *= i #n개의 수들의 곱
        
        for x in range(len(arr)):
            result = result // arr[x] #소수점 오류 날까봐
            #result 나누기 모든 수의 나머지 0인지 체크
            for y in range(len(arr)):
                if result % arr[y] !=0:
                    result *= arr[x] 
                    break
            
    return result
