package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 10824번 네 수 */
public class boj_10824 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String n1 = st.nextToken() + st.nextToken();
		String n2 = st.nextToken() + st.nextToken();
		
		System.out.println(Long.parseLong(n1) + Long.parseLong(n2));
	}
}
