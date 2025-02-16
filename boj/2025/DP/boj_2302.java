import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2302번 극장 좌석 */
public class boj_2302 {

    static int N, M;
    static int[] dp;
    static boolean[] flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 총 좌석 수
        M = Integer.parseInt(br.readLine()); // 고정석 수

        dp = new int[N + 1];
        flag = new boolean[N + 1];

        // 좌석이 1개일 경우
        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            flag[temp] = true;  // vip석(고정석) 체크
        }

        dp[1] =  1; // 좌석 1개일 때
        dp[2] = 2; // 좌석 2개일 때
        if (N > 2) {
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }

        int answer = 1;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (flag[i]) { // vip석(고정석) 일 때
                if (count == 0) continue;

                answer *= dp[count];
                count = 0; // 초기화
            } else {
                count++;
            }
        }

        // 마지막 좌석이 고정석이 아닐 경우 존재
        if (count > 0) {
            answer *= dp[count];
        }

        System.out.println(answer);

    }
}
