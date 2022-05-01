package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2609번 최대공약수와 최소공배수 */
public class boj_2609 {
	
	static int n1, n2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		
		System.out.println(divisor(n1, n2));
		System.out.println(multiple(n1, n2));
		
	}

	// 최대공약수
	static int divisor(int n1, int n2) {
		if(n2 == 0) return n1;
		
		return divisor(n2, n1 % n2);
	}
	
	// 최소공배수
	static int multiple(int n1, int n2) {
		return ((n1 * n2) / divisor(n1, n2));
	}
}
