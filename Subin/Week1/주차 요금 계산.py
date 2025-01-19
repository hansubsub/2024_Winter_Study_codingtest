import math
def solution(fees, records):
    answer = []
    time_l = {} #주차장에 있는 차량의 주차시간
    car = {} # 주차장에 있는 차량
    for record in records:
        time,number,io = record.split()
        hour,min = map(int,time.split(":"))
        minutes = hour * 60 + min
        if io=="IN":
            car[number] = minutes #딕셔너리에 추가
        elif io =="OUT":
            if number in time_l:
                time_l[number] += (minutes- car[number])
            else:
                time_l[number] = minutes - car[number]
            del car[number] #출차하면 삭제
    #23:59까지 출차 하지 않은 차량 시간 
    for number, minutes in car.items():
        if number in time_l:
            time_l[number] += 1439 - minutes
        else:
            time_l[number] = 1439 - minutes
            
    #차량번호 기준으로 정렬후 요금 계산
    d_time, d_fee, u_time, u_fee = fees
    for number, total_time in sorted(time_l.items(), key=lambda x: x[0]):
        if total_time <= d_time:
            fee = d_fee
        else:
            fee = d_fee + math.ceil((total_time - d_time) / u_time) * u_fee
        answer.append(fee)

    return answer
        
            
