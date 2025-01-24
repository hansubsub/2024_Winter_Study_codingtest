s = input()
result = int(s[0]) #데이터 타입 변환 중요!
for i in range(len(s)-1):
    num = int(s[i+1]) #데이터 타입 변환을 위해 넣은 코드드
    if result<=1 or num <=1:
        result += num
    else:
        result *= num

print(result)	
