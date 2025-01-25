package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 1986번 지그재그 숫자 (D2) */
public class swea_1986 {

    static int T, N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            N = Integer.parseInt(br.readLine());

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if(i % 2 == 1) sum += i;
                else sum -= i;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
