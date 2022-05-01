package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 6603번 로또 */
public class boj_6603 {

	static int K , SIZE = 6;
	static int[] S, Lotto;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// K에 0이 들어올때까지 입력 받는다.
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			K = Integer.parseInt(st.nextToken());
			
			S = new int[K];
			Lotto = new int[SIZE];
			select = new boolean[K];

			// K가 0이 들어오면 종료
			if(K == 0) break;
			
			for(int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			Perm(0, 0);
			System.out.println();
		}
		
	}
	
	static void Perm(int strIdx, int cnt) {
		// 기저 조건
		if(cnt == SIZE) {
			for(int i = 0; i < SIZE; i++) {
				System.out.print(Lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = strIdx; i < K; i++) {
			if(!select[i]) {
				select[i] = true;
				Lotto[cnt] = S[i];
				Perm(i, cnt + 1);
				select[i] = false;
			}
		}
	}
}
