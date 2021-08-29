package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 1948번 날짜 계산기 (D2) */
public class swea_1948 {

	static int testCase;
	static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			if(m1 == m2) {
				result = (d2 - d1) + 1;
			}else {
				result += (days[m1] - d1 + d2 + 1);
				for (int i = m1 + 1; i < m2; i++) {
					result += days[i];
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
