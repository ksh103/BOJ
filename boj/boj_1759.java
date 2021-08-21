package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 1759번 암호 만들기 */
public class boj_1759 {

	static int L, C;
	static char[] alphabet, value;
	static boolean[] select;

	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		alphabet = new char[C];
		select = new boolean[C];
		value = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		// 사전순으로 정렬
		Arrays.sort(alphabet);
		DFS(0, 0);
		
	}
	
	static void DFS(int strIdx, int cnt) {
		// 기저조건
		if(cnt == L) {
			check();
			return;
		}
		for(int i = strIdx; i < C; i++) {
			if(!select[i]) {
				select[i] = true;
				value[cnt] = alphabet[i];
				DFS(i, cnt + 1);
				select[i] = false;
			}
		}
	}
	
	static void check() {
		int a = 0, b = 0;
		
		for(int i = 0; i < L; i++) {
			// 모음
			if(value[i] == 'a' || value[i] == 'e' || value[i] == 'i' || value[i] == 'o' || value[i] == 'u') {
				a++;
			}else { // 자음
				b++;
			}
		}
		// 한 개의 모음 최소 두개의 자음으로 구성 된 암호 
		if(a >= 1 && b >= 2) {
			System.out.println(value);
		}
	}
}
