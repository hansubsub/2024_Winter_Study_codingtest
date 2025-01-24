import java.util.*;
import java.io.*;

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int disLastIndex = discount.length - 1;
        // 초기 10개의 항목을 map에 추가
        for (int i = 0; i < 10; i++) {
            if (i > disLastIndex) break;
            String str = discount[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i + 9 <= disLastIndex; i++) {
            if (check(want, number, map)) count++;
            
            // map 업데이트
            if (i + 10 <= disLastIndex) {
                String removeKey = discount[i];
                String addKey = discount[i + 10];

                // 전 시작 값을 제거
                map.put(removeKey, map.get(removeKey) - 1);
                if (map.get(removeKey) == 0) {
                    map.remove(removeKey);
                }

                // 새로운 끝 값을 추가
                map.put(addKey, map.getOrDefault(addKey, 0) + 1);
            }
        }
        return count;
    }

    public static boolean check(String[] want, int[] number, Map<String, Integer> map) {
        for (int i = 0; i < want.length; i++) {
            String key = want[i];
            if (!map.containsKey(key) || map.get(key) < number[i]) {
                return false;
            }
        }
        return true;
    }
}
