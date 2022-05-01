package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/* boj 2776번 암기왕 */
public class boj_2776 {

	static int T, N, M;
	static HashSet<Integer> list = new HashSet<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int note = Integer.parseInt(st.nextToken());
				
				if(list.contains(note)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			list.clear();
		}
		System.out.println(sb);
	}
}
