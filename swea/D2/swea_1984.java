package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* swea 1984번 중간 평균값 구하기(D2) */
public class swea_1984 {

    static int T;
    static int[] numbers = new int[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 10; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            double sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += numbers[i];
            }
            double res = sum / 8;
            // System.out.println(res);
            System.out.println("#" + t + " " + Math.round(res));
        }
    }
}
