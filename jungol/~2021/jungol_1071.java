package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* jungol 1071번 약수와 배수 */
public class jungol_1071 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int a_sum = 0, b_sum = 0;
		for (int i = 0; i < N; i++) {
			if(M % arr[i] == 0) {
				a_sum += arr[i]; // 약수의 합
			}
			if(arr[i] % M == 0) {
				b_sum += arr[i]; // 배수의 합
			}
			
		}
		System.out.println(a_sum);
		System.out.println(b_sum);
	}
}
