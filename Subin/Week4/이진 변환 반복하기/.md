### 이진 변환 반복하기

📌 문제 설명

[코딩테스트 연습 - 이진 변환 반복하기 | 프로그래머스 스쿨](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

📌 문제 접근법

0 개수 세고 → rplace로 0 없애고 → 길이 측정하고 → 2진수로 바꾸는걸 1이 될때까지 반복해야겠다고 생각함

📌 배운점

- 2진수 변환 함수 `bin`
  
```
num = 42
binary = bin(num)  # 결과: '0b101010' 
print(binary)
```
