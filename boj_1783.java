package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1783번 병든 나이트 */
public class boj_1783 {

	static int N, M, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		
		if(N == 1) result = 1;
		else if (N == 2) result = Math.min((M+1) / 2, 4);
		else if (N >= 3) {
			if(M < 7) {
				result = Math.min(M, 4);
			}else if(M >= 7) {
				result = M-2;
			}
		}
		System.out.println(result);
	}
}
