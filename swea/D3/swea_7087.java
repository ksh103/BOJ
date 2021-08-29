package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* swea 7087번 문제 제목 붙이기 (D3) */
public class swea_7087 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			
			int N = Integer.parseInt(br.readLine());
			String[] alphabet = new String[N];
			
			for (int i = 0; i < N; i++) {
				alphabet[i] = br.readLine();
			}
			
			// 알파벳 사전 순서로 정렬
			Arrays.sort(alphabet);
			
			char ch = 'A';
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(i == 0) {
					// 첫번째 제목은 무조건 A가 와야된다.
					if(alphabet[i].charAt(0) == ch) cnt++;
					// 첫번째 제목이 A가 아니면 break
					else break;
				}
				if(alphabet[i].charAt(0) == ch) continue;
				// 알파벳 순서대로 카운터 
				if(alphabet[i].charAt(0) == ++ch) cnt++;
				// 알파벳이 더 이상 이어지지 않으면 break
				else break;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
