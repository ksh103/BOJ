package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1062번 가르침 */
public class boj_1062 {

	static int N, K, max;
	static int[][] word;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		word = new int[N][26];
		isSelected = new boolean[26];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			
			int size = input.length();
			for (int j = 0; j < size; j++) {
				word[i][input.charAt(j) - 'a'] = 1;
			}
		}
		perm(0, 0);
		System.out.println(max);
	}
	
	// N개의 글자 중 K개의 글자를 가르칠 때
	static void perm(int strIdx, int cnt) {
		if(cnt == K) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				
				for (int j = 0; j < 26; j++) {
					if(word[i][j] == 1 && !isSelected[j]) {
						flag = false;
						break;
					}
				}
				if(flag) res++;
			}
			max = Math.max(max, res);
			return;
		}
		
		for (int i = strIdx; i < 26; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			perm(i, cnt + 1);
			isSelected[i] = false;
		}
	}
}
