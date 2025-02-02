class n개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0]; // 배열의 첫 번째 원소 초기화 -> 최소공배수 초기값 설

        // i = 1부터 반복
        for (int i = 1; i < arr.length; i++) {
            // 현재까지의 최소공배수와 현재 원소의 최대공약수 계산
            int gcd = gcd(answer, arr[i]);

            // 최소공배수 갱신
            answer = answer * arr[i] / gcd;
        }

        return answer; // 최소공배수 반환
    }

    // 최대공약수 계산 함수
    private static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        // 나누어 떨어지지 않을 때까지 반복
        while (x % y != 0) { 
            int z = x % y; // 나머지 계산 과정
            x = y; // 큰 값을 작은 값으로 바꿔주는 과정
            y = z; // 작은 값을 나머지로 바꿔주는 과정
        }

        return y; // 다 나눠 떨어지면 y가 최대공약수가 됨
    }
}
