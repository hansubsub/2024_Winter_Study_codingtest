package Study_codingtest.dongwook.week2.귤고르기;

import java.util.*;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        // 귤 크기별 개수를 계산하여 맵에 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
            // map.getOrDefault(size, 0)는 귤 크기 size가 이미 맵에 존재하면 개수를 가져오고, 없으면 0을 가져온다 그리고 1씩 증가시켜 귤 개수를 세주는 과정이다.
        }

        // 귤 크기별 개수를 내림차순으로 정렬
        List<Integer> countList = new ArrayList<>(map.values());
        Collections.sort(countList, Collections.reverseOrder());

        int sum = 0; // 고를 귤의 개수
        int cnt = 0; // 귤을 고른 종류 수

        // 고른 귤의 수가 k 이상이 될 때까지 반복
        for (int count : countList) { // countList를 순차적으로 탐색하여 귤의 개수를 하나씩 더하는 과
            sum += count;
            cnt++;
            if (sum >= k) { // sum이 k 이상이면 탈출
                break;
            }
        }

        return cnt; // 고른 귤 cnt 값 반환 과정
    }
}
