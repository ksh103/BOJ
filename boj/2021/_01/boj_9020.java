package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 9020번 골드바흐의 추측 */
public class boj_9020 {

	static int T;
	static boolean[] primes = new boolean[10001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Prime();
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int left = N / 2;
			int right = N / 2;
			
			while(true) {
				if(primes[left] && primes[right]) {
					sb.append(left + " ").append(right + "\n");
					break;
				}
				left--;
				right++;
			}
		}
		System.out.println(sb);

	}
	
	
	// 소수 구하기
	static void Prime() {
		primes[0] = primes[1] = false;
		
		for (int i = 2; i < 10001; i++) {
			primes[i] = true;
		}
		
		for (int i = 2; i*i < 10001; i++) {
			for (int j = i*i; j < 10001; j+=i) {
				primes[j] = false;
			}
		}
	}
}