import java.io.BufferedReader;
import java.io.InputStreamReader;

/* bog 1309번 동물원 */
public class boj_1309 {

    static final int MOD = 9901;
    static int N;
    static long answer = 1;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N][3];

        dp[0][0] = 1; // 사자를 넣지 않는 경우
        dp[0][1] = 1; // 사자를 왼쪽에 넣는 경우
        dp[0][2] = 1; // 사자를 오른쪽에 넣는 경우

        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD; // 사자를 넣지 않는 경우 + 왼쪽에 넣는 경우 + 오른쪽에 넣는 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; // 사자를 넣지 않는 경우 + 오른쪽에 넣는 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD; // 사자를 넣지 않는 경우 + 왼쪽에 넣는 경우
        }

        answer = (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % MOD;

        System.out.println(answer);
    }
}
