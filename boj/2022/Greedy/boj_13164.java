package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 13164번 행복 유치원 */
public class boj_13164 {

    static int N, K;
    static int[] arr, diff;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 유치원 원생 수
        K = Integer.parseInt(st.nextToken()); // 조의 개수

        arr = new int[N];
        diff = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++) {
            // 키 큰 원생 - 키 작은 원생
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff); // 정렬

        int sum = 0;
        for(int i = 0; i < N - K; i++) {
            // N - K 만큼 더해주면 된다.
            sum += diff[i];
        }

        System.out.print(sum);
    }
}
