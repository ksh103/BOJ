package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 22858번 원상 복구 (small) */
public class boj_22858 {

	static int N, K;
	static int[] D, P, S;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		P = new int[N + 1];
		D = new int[N + 1];
		S = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		while(K --> 0) {
			for(int i = 1; i <= N; i++) {
				P[D[i]] = S[i];
			}
			for(int i = 1; i <= N; i++) {
				S[i] = P[i]; // 섞은 카드 저장
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(S[i] + " ");
		}
	}

}
