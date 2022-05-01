package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2251번 물통 */
public class boj_2251 {

	static int A, B, C;
	static boolean[] result = new boolean[201];
	static boolean[][] visited = new boolean[201][201];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		DFS(0, 0, C);
		
		for (int i = 0; i < 201; i++) {
			if(result[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	static void DFS(int a, int b, int c) {
		if(visited[a][b]) return;
		
		if(a == 0) result[c] = true;
		
		visited[a][b] = true;
		
		// 물통이 비워질때까지 붓거나 다른 물통이 가득 찰때까지만 물을 부을 수 있음
		// a -> b
		if(a+b > B) {
			DFS((a+b)-B, B, c);
		}else {
			DFS(0, a+b, c);
		}
		
		// b -> a
		if(b+a > A) {
			DFS(A, (b+a)-A, c);
		}else {
			DFS(b+a, 0, c);
		}
		
		// c -> a
		if(c+a > A) {
			DFS(A, b, (c+a)-A);
		}else {
			DFS(c+a, b, 0);
		}
		
		// c -> b
		if(c+b > B) {
			DFS(a, B, (c+b)-B);
		}else {
			DFS(a, c+b, 0);
		}
		
		DFS(a, 0, b+c);
		DFS(0, b, a+c);
	}
}
