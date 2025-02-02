public class 멀리뛰기 {
    public long solution (int n){
        // dp 배열 생성하여 n + 2 크기로 선언함
        long[] dp = new long[n+2]; 
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++){ // n이 3이상일 경우, dp[i]값을 점화식을 통해서 구한다.
            dp[i] = dp[i-1] + dp[i-2] % 1234567; // 1234567로 나눈 이유는 숫자가 매우 커질 수가 있어서다
        }
        return dp[n]; // n칸에 도달하는 경우의 수를 반환하는 과정이다
    }
}
