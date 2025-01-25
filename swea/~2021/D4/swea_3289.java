package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 21.08.24 */
/* swea 3289번 서로소 집합 (D4) */
public class swea_3289 {

	static int testCase, N, M;
	static int[] numbers;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 연산의 개수
			M = Integer.parseInt(st.nextToken()); // M개의 줄
			
			numbers = new int[N+1];
			
			for(int i = 0; i <=N; i++) {
				numbers[i] = i;
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int check = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			
				// check == 0이면 합집합
				if(check == 0) {
					union(a,b);
				}else if(check == 1) { // check == 1이면 집합이 포함되어 있는지
					if(find(a, b)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	
	static int findSet(int a) {
		if(a == numbers[a]) return a;
		return numbers[a] = findSet(numbers[a]);
	}
	
	//  같으면 합치기
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		numbers[bRoot] = aRoot;
		return true;
	}
	
	static boolean find(int a, int b) {
		if (findSet(a) == findSet(b)) return true;
		else return false;
	}
}
