package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 1654번 랜선 자르기 */
public class boj_1654 {

	static int K, N;
	static int[] lanline;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
				
		lanline = new int[K];
		
		for (int i = 0; i < K; i++) {
			lanline[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lanline);
		binarySearch(lanline);
	}
	
	static void binarySearch(int[] lanline) {
		long start = 1;
		long end = lanline[K-1];
		long result = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			
			// 개수가 N개 이상인 경우 크기를 더 늘릴 수 있고
			// N개보다 적을 경우 현재 mid 값으로 랜선을 자를 수 없다.
			if(check(mid, lanline)) {
				result = Math.max(result, mid);
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
	
	static boolean check(long mid, int[] lanline) {
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			// 잘라서 나오는 개수를 더함.
			cnt += lanline[i] / mid;
		}
		return cnt >= N;
	}	
}
