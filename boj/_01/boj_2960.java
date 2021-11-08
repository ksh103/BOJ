package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2960번 에라토스테네스의 체 */
public class boj_2960 {

	static int N, K;
	static boolean[] prime;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		prime = new boolean[N+1];

		prime();
	}
	
	static void prime() {
		int cnt = 0;
	
		prime[0] = prime[1] = false;
		
		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j+=i) {
				if(!prime[j]) continue;
				prime[j] = false;
				cnt++;
				
				if(cnt == K) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}
