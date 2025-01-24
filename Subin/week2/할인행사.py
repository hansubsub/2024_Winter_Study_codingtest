def solution(want, number, discount):
    answer = 0
    buy = {}
    for i in range(len(want)):
        buy[want[i]] = number[i] #딕셔너리로 구매 리스트 만듦
    all = sum(number) #총 사야하는 물건 수
    #10일씩 몇 번 묶을것인가
    for x in range(len(discount)-9):
        check = buy.copy() #수량 비교 위한 사전
        check_num = 0 #다 구매했는지 확인하기 위한 변수
        
        for y in range(10):
            if discount[x+y] in check and check[discount[x+y]]>0:
                check[discount[x+y]]-=1
                check_num += 1
                
        if check_num == all: #다 구매됐을때만 answer++
            answer +=1

    return answer
