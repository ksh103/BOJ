package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2908번 상수 */
public class boj_2908 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() + " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		String tmpA = "";
		for (int i = A.length() - 1; i >= 0; i--) {
			tmpA += A.charAt(i);
		}
		
		String tmpB = "";
		for (int i = B.length() - 1; i >= 0; i--) {
			tmpB += B.charAt(i);
		}
		
		int max = Math.max(Integer.parseInt(tmpA), Integer.parseInt(tmpB));

		System.out.println(max);
	}
}
