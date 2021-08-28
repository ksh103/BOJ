package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 9019번 DSLR */
public class boj_9019 {
	
	static int T, A, B;
	static boolean[] select;
	static Queue<Register> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			select = new boolean[10000];
			BFS(A,B);
			sb.append("\n");
			queue.clear();
		}
		System.out.println(sb);
		
	}
	static void BFS(int a, int b) {
		select[a] = true;
		queue.offer(new Register(a, ""));
		
		while(!queue.isEmpty()) {
			Register re = queue.poll();
			int num = re.num;
			String op = re.op;
			
			if(num == b) {
				sb.append(op);
				return;
			}
			
			// D
			int d = (num * 2);
			if(d > 9999) {
				d %= 10000;
			}
			if(!select[d]) {
				select[d] = true;
				queue.offer(new Register(d, op+"D"));
			}
			
			// S
			int s = num == 0 ? 9999 : num -  1;
			if(!select[s]) {
				select[s] = true;
				queue.offer(new Register(s, op+"S"));
			}
			
			// L
			int l = ((num % 1000) * 10) + (num / 1000);
			if(!select[l]) {
				select[l] = true;
				queue.offer(new Register(l, op+"L"));
			}
			
			// R
			int r = ((num % 10) * 1000) + (num / 10);
			if(!select[r]) {
				select[r] = true;
				queue.offer(new Register(r, op+"R"));
			}
		}
		
	}	
	static class Register{
		int num;
		String op;
		
		public Register(int num, String op) {
			this.num = num;
			this.op = op;
		}
	}
}
