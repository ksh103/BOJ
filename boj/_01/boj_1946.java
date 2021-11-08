package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 1946번 신입 사원 */
public class boj_1946 {

	static int T, N;
	static Pair[] pair;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			pair = new Pair[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				pair[i] = new Pair(paper, interview);
			}
			
			Arrays.sort(pair);

			int count = 0;
			int res = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if(res > pair[i].b) {
					res = pair[i].b;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Pair o) {
			return this.a - o.a;
		}
	}
}

