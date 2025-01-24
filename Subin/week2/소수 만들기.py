from itertools import combinations

def solution(nums):
    answer =0
    combi = list(combinations(nums, 3)) #3개씩 모든 조합 저장
    
    check = [] #3개 합 리스트
    for x in range(len(combi)):
        check.append(sum(combi[x]))
    
    no=[] #소수가 아닌 리스트
    all = len(check)  # 전체 조합의 개수
   #소수 아닌거 판별
    for i in range(len(check)):
        if check[i]==1:
                no.append(1)
        else:
            for j in range(2,check[i]): 
                if check[i]%j==0:
                    no.append(check[i])
                    break
    return all - len(no)
                
    
    
