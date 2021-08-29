package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 4698번 테네스의 특별한 소수 (D3) */
public class swea_4698 {

	static int D, A, B;
	static boolean[] primes = new boolean[1000001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		prime();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());  // D를 포함하는 소수
			A = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());
		
			System.out.println("#" + t + " " + check(D, A, B));
		}
	}
	
	// 범위 내에 특정 숫자를 포함하는 소수 여부 판단
	static int check(int d, int a, int b) {

		int cnt = 0;
		
		for (int i = A; i <= B; i++) {
			if(primes[i] == true) {
				String str = Integer.toString(i);
				if(str.contains(Integer.toString(D))) cnt++;
			}
		}
		return cnt;
	}
	
	// 소수 구하기 (에라스토테네스의 체)
	static void prime() {
		
		primes[0] = primes[1] = false;
		
		for (int i = 2; i <= 1000000; i++) {
			primes[i] = true;
		}
		
		for(int i = 2; i*i <= 1000000; i++) {
			for (int j = i*i; j <= 1000000; j+=i) {
				primes[j] = false;
			}
		}
	}
}
