package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 6159번 코스튬 파티 */
public class boj_6159 {

    static int N, S;
    static int[] data;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()); // 코스튬 크기

        data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);
        
        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            int sum = data[i];
            for (int j = i + 1; j < N; j++) {
                if(sum + data[j] <= S) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
