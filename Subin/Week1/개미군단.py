#프로그래머스 추천에 떠서 풀었는데 0lv 문제였다..!
def solution(hp):
    return hp//5 + (hp%5)//3 + (hp%5)%3
