import java.util.*;

class Solution { 
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트
        int result = 0; // 트럭에 실은 상자 개수
        int currentBox = 1; // 컨테이너 벨트에서 첫 상자 번호

        for (int target : order) {
            // target에 도달할 때까지 컨테이너 벨트에서 상자를 스택으로 이동
            while (currentBox <= order.length && currentBox < target) {
                stack.push(currentBox);
                currentBox++;
            }

            // 현재 상자가 target과 일치할 경우
            if (currentBox == target) {
                result++;
                currentBox++; // 다음 상자로 이동
            }
            // 보조 컨테이너 벨트에서 target을 꺼낼 수 있는 경우
            else if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                result++;
            }
            // target을 적재할 수 없는 경우
            else {
                break; // 작업 중단
            }
        }

        return result; // 최종적으로 실은 상자 개수 반환
    }
}
