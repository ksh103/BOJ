package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2702번 초6 수학 */
public class boj_2702 {

	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(multiple(a, b) + " " + divisor(a, b));
		}
	}
	
	// 최대공약수
	static int divisor(int a, int b) {
		if(b == 0) return a;
		return divisor(b, a % b);
	}
	
	// 최소공배수
	static int multiple(int a, int b) {
		return (a * b) / divisor(a, b);
	}
}
