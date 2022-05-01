package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 13908번 비밀번호 */
public class boj_13908 {

	static int n, m, result;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 비밀번호의 길이
		m = Integer.parseInt(st.nextToken()); // 비밀번호에 들어가는 수

		check = new boolean[10];
		
		// 중요 ! : m이 0인 경우 둘째 줄은 주어지지 않는다.
		if(m != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
		}

		Comb(0, 0);
		System.out.println(result);
	}
	
	static void Comb(int index, int num) {
		if(index == n) {
			if(num == m) result++;
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(check[i]) {
				check[i] = false;
				Comb(index + 1, num + 1);
				check[i] = true;
			} else Comb(index + 1, num);
		}
	}
}
