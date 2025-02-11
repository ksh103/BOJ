import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2579번 계단 오르기 */
public class boj_2579 {

    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];

        // 계단이 1개인 경우도 존재.
        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= N; i++) {
            // 1. 한번에 두 계단
            // 2. 한 계단 + 두 계단
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[N]);

    }
}
