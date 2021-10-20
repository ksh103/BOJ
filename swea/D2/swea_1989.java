package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 1989번 초심자의 회문 검사 (D2) */
public class swea_1989 {
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            String input = br.readLine();

            if(check(input)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static boolean check(String str){
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
