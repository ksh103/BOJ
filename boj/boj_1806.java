package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1806번 부분합 */
public class boj_1806{

    static int N, S, len;
    static int[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        graph = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        len = Integer.MAX_VALUE;
        solution();

        System.out.println((len == Integer.MAX_VALUE) ? 0 : len);
    }

    static void solution(){
        int start = 0, end = 0, sum = 0;

        while(true){
            if(sum < S){
                if(end == N) break;
                sum += graph[end++];
            }else if(sum >= S){
                sum -= graph[start++];
                len = Math.min(len, end - start + 1);
            }
        }
    }
}