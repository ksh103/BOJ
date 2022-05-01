package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* boj 11581번 텔레포트 */
public class boj_11581 {

	static int N;
	static int[] isSelected;
	static LinkedList<Integer> list[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new LinkedList[N+1];
		isSelected = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		solve(1);
		
		System.out.println("NO CYCLE");
	}
	
	static void solve(int a) {
		// 1 : 방문 o, 2 : 방문 완료
		if(isSelected[a] == 1) {
			System.out.println("CYCLE");
			System.exit(0);
		}
		
		isSelected[a] = 1;
		
		for (int b : list[a]) {
			if(isSelected[b] != 2) solve(b);
		}
		
		isSelected[a] = 2;
	}
}
