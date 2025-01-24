package Study_codingtest.dongwook.week2.n제곱배열자르기;

public class n제곱배열자르기 {
    public int[] solution(int n, long left, long right){
        int len = (int) right - (int) left; // 반환할 배열 길이 계산 -> 여기서 left, right가 long 타입이므로 int로 강제 형변환 과정이 이뤄저야함
        int[] answer = new int[len + 1]; // 결과값 배열을 초기화하는 단계
        // len + 1크기의 배열을 생성하는 이유는 right, left가 주어지면 right - left + 1 크기의 요소를 가져야하니까!!

        int idx = 0; // 결과 배열 인덱스 0으로 초기화
        for (long i = left; i <= right; i++) {
            long row = i / n; // 행 번호 계산하는 과정
            long col = i % n; // 열 번호 계산하는 과
            answer[idx++] = Math.max((int)row, (int)col) + 1; // 행과 열 중 큰 값에 1을 더해 배열에 저장하는 과정
        }
        return answer; // 결과 배열 반환과
    }
}
