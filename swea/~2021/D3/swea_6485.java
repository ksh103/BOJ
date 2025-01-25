package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 6485번 삼성시의 버스 노선 (D3) */
public class swea_6485 {

	static int N, P;
	static int[] a, b, c, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			N = Integer.parseInt(br.readLine());
			
			a = new int[N]; 
			b = new int[N];
			
			// 버스 노선
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			P = Integer.parseInt(br.readLine()); // 정류장 개수
			
			c = new int[P];
			
			for (int i = 0; i < P; i++) {
				c[i] = Integer.parseInt(br.readLine());
			}
			
			count = new int[P];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < P; j++) {
					// A노선 이상 B노선 이하
					if(a[i] <= c[j] && b[i] >= c[j]) {
						count[j]++;
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < P; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println();
			
		}
	}
}
