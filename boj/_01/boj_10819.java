package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 10819번 차이를 최대로 */
public class boj_10819 {

	static int N, max;
	static int[] numbers;
	static boolean[] select;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		select = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Perm(0, new int[N]);
		System.out.println(max);
	}
	
	static void Perm(int tgtIdx, int[] arr) {
		int sum =0;
		if(tgtIdx == N) {
			for(int i = 0; i < N-1; i++) {
				// |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
				sum += Math.abs(arr[i] - arr[i+1]);
			}
			max = Math.max(max, sum); 
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!select[i]) {
				select[i] = true;
				arr[tgtIdx] = numbers[i];
				Perm(tgtIdx + 1, arr);
				select[i] = false;
			}
		}
	}
}
	

