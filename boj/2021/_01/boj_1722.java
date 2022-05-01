package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1722번 순열의 순서 */
public class boj_1722 {

	static int N, K;
	static int[] numbers;
	static long[] f;
	static boolean[] select;

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		numbers = new int[N+1];
		f = new long[21];
		select = new boolean[N+1];
		
		f[0] = 1;
		for(int i = 1; i < 21; i++) {
			f[i] = f[i-1] * i;
		}

		if(K == 1) { 
			Long I = Long.parseLong(st.nextToken());
			
			for(int i = 0; i < N; i++) { 
				for(int j = 1; j <= N; j++) {
					if(select[j]) continue;
					
					if(f[N-i-1] < I) I -= f[N-i-1];
					else {
						numbers[i] = j; 
						select[j] = true;
						break;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				System.out.print(numbers[i] + " ");
			}
			
		} else if(K == 2){	
			for(int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			long result = 1L;
			
			for(int i = 0; i < N; i++) {
				for(int j = 1; j < numbers[i]; j++) {
					if(!select[j]) {
						result += f[N-i-1];
					}
				}
				select[numbers[i]] = true;
			}

			System.out.println(result);
		}
	}
}
