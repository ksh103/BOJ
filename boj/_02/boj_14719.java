package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 14719번 빗물 */
public class boj_14719 {

	static int H, W;
	static int[] wall;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		wall = new int[W];
		
		int maxH = 0, maxIdx = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			wall[i] = Integer.parseInt(st.nextToken());
			
			if(maxH < wall[i]) {
				maxH = wall[i];
				maxIdx = i;
			}
		}
		
		int maxLeft = 0, maxRight = 0;
		int sumLeft = 0, sumRight = 0;
		
		// 왼쪽
		for (int i = 0; i < maxIdx; i++) {
			if(maxLeft < wall[i]) maxLeft = wall[i];
			else sumLeft += (maxLeft - wall[i]);
		}
		
		// 오른쪽
		for (int i = W-1; i > maxIdx; i--) {
			if(maxRight < wall[i]) maxRight = wall[i];
			else sumRight += (maxRight - wall[i]);
		}
		
		System.out.println(sumLeft + sumRight);
	}
}
