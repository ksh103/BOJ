package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* boj 2217번 로프 */
public class boj_2217 {

    static int N;
    static int[] roop;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        roop = new int[N];

        for(int i = 0; i < N; i++) {
            roop[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(roop); // 정렬

        int max = 0;

        for(int i = 0; i < N; i++) {
            int value = roop[i] * (N - i);

            max = Math.max(max, value);
        }

        System.out.println(max);
    }
}

