# [level 2] N개의 최소공배수 - 12953 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12953) 

---

### 문제 설명

<p>두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요. </p>

<h5>제한 사항</h5>

<ul>
<li>arr은 길이 1이상, 15이하인 배열입니다.</li>
<li>arr의 원소는 100 이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>arr</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[2,6,8,14]</td>
<td>168</td>
</tr>
<tr>
<td>[1,2,3]</td>
<td>6</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

---

### 아이디어
최소공배수를 구하는 방법만 알고있으면 쉬움. <br>
-> A와 B. 두 수의 최소 공배수를 구하는 방법은? **A * B / A와 B의 gcd(최소공약수)**

최소공약수를 구하는 로직은 재귀로 구현<br>
main함수인 solution함수에서 최소공배수를 구하는 방법으로 주어진 배열에서, <br>
1번과 2번의 최소공배수 구하기 -> (1번과 2번의 최소공배수) 와 3번의 최소공배수 구하기 -> ... <br>
로 주어진 배열의 마지막 수까지 쭉쭉 구해주면 된다. 
