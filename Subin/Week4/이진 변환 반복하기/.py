def solution(s):
    zero = 0
    cnt =0
    while s != '1':
        zero += s.count('0')
        s = bin(len((s.replace('0',''))))[2:]
        cnt += 1
        
    return [cnt, zero]
