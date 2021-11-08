package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 3985번 롤 케이크 */
public class boj_3985 {

    static int L, N, P, K;
    static int[] cake, pNum1, pNum2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine()); // 롤케이크의 길이
        N = Integer.parseInt(br.readLine()); // 방청객의 수

        cake = new int[L+1];
        pNum1 = new int[N+1];
        pNum2 = new int[N+1];

        int p1 = 0, r1 = 0, p2 = 0, r2 = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            P = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            /* 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호 */
            pNum1[i] = K - P + 1; // 롤케이크 조각
            if(p1 < pNum1[i]){
                p1 = pNum1[i];
                r1 = i; // 방청객 번호
            }

            /* 실제로 가장 많은 조각을 받은 방청객의 번호를 출력 */
            int cnt = 0;
            for (int j = P; j <= K; j++) {
                // 이미 번호가 적혀있는 조각은 번호를 적지 못함.
                if(cake[j] == 0){
                    cake[j] = i;
                    cnt++;
                }
            }
            pNum2[i] = cnt;
            if(p2 < pNum2[i]){
                p2 = pNum2[i];
                r2 = i;
            }   
        }
        System.out.println(r1 + "\n" + r2);
    }
}
