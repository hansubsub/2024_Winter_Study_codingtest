import java.util.*;

class Solution {//
    public int solution(int n, int m, int[] section) {
        // 페인트칠이 필요한 구역번호와 칠해졌는지 여부를 boolean 사용
       Map<Integer, Boolean> paintWall = new HashMap<>();
        for(int k : section){
            paintWall.put(k, false); // 칠하지않은 상태
        }
        int paintCnt = 0;
        int lastPaint = 0;
        
        for(int k : section){
            if(paintWall.get(k)){
                continue;
            }
            paintCnt++;
            lastPaint = k + m - 1;
            
            for(int i = k; i<= lastPaint && i<=n; i++){
                if(paintWall.containsKey(i)){
                    paintWall.put(i,true);
                }
            }
        }
         return paintCnt;
    }
}
