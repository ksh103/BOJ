package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2908번 도로와 신호등 */
public class boj_2980 {

    static int N, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 신호등의 개수
        L = Integer.parseInt(st.nextToken()); // 도로의 길이

        int time = 0;
        int position = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int D = Integer.parseInt(st.nextToken()); // 신호등 위치
            int R = Integer.parseInt(st.nextToken()); // 빨간색 지속되는 시간
            int G = Integer.parseInt(st.nextToken()); // 초록색 지속되는 시간

            time += D - position;
            position = D;

            int redLight = time % (R + G);

            // 빨간불이 끝날때까지 대기
            if(redLight < R) {
                time += R - redLight;
            }
        }

        System.out.print(time + (L - position));
    }
}
