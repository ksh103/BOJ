package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2304번 창고 다각형 */
public class boj_2304 {

	static int N, idx, height, maxHeight = 0, maxIdx = 0, endIdx = 0;
	static int[] bar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		bar = new int[1001];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			idx = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			bar[idx] = height;
			
			// 제일 높은 높이 저장
			if(maxHeight < height) {
				maxHeight = height;
				maxIdx = idx;
			}
			
			// 마지막 인덱스 저장
			if(endIdx < idx) {
				endIdx = idx;
			}
		}
		
		int sum = 0;
		int tmpHeight = 0;
		
		// 첫번째 인덱스부터 제일 높은 높이가 저장된 인덱스까지 
		for(int i = 0; i <=maxIdx; i++) {
			// 높은 높이가 나올때마다 갱신하면서 더해나감
			if(tmpHeight < bar[i]) {
				tmpHeight = bar[i];
			}
			sum += tmpHeight;
		}
		
		tmpHeight = 0;
		
		// 마지막 인덱스부터 제일 높은 높이가 저장된 인덱스까지
		for(int i = endIdx; i > maxIdx; i--) {
			// 높은 높이가 나올때마다 갱신하면서 더해나감
			if(tmpHeight < bar[i]) {
				tmpHeight = bar[i];
			}
			sum += tmpHeight;
		}
		
		System.out.println(sum);
	}
}
