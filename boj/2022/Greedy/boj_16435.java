package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 16435번 스네이크버드 */
public class boj_16435 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 과일의 개수
        int L = Integer.parseInt(st.nextToken()); // 스네이크버드의 초기 길이 정수

        int[] h = new int[N]; // 과일의 높이

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(h);

        for(int i = 0; i < N; i++) {
            // 자신의 길이보다 작거나 같은 높이에 있는 과일을 먹을 수 있음
            if(h[i] <= L) L++;
            else break;
        }

        System.out.print(L);
    }
}
