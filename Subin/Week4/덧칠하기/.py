def solution(n, m, section):
    answer = 0
    paint = 0
    #색칠한 부분의 끝위치를 이용하여 연산해야함
    for x in section:
        if x>paint:
            paint = x+ (m-1)
            answer+=1
    return answer
