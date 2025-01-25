package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 1926번 간단한 369게임(D2) */
public class swea_1926 {
    static int N, cnt;
    static boolean check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        N = Integer.parseInt(br.readLine());

        cnt = 0;
        for (int i = 1; i <= N; i++) {
            String input = String.valueOf(i);
            input = input.replaceAll("3|6|9", "-");
            
            if(input.contains("-")){
                for (int j = 0; j < input.length(); j++) {
                    if(input.charAt(j) == '-') sb.append("-");
                }
            }else sb.append(input);

            sb.append(" ");
        }
        System.out.println(sb);
    }
}
