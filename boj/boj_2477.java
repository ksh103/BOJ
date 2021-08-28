package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2477번 참외밭 */
public class boj_2477 {

	static int N;
	static int[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[6];
		
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int hMax = 0, wMax = 0;
		for (int i = 0; i < 6; i++) {
			if(i % 2 == 0) {
				wMax = Math.max(wMax, map[i]);
			}else {
				hMax = Math.max(hMax, map[i]);
			}
		}
		
		int hMin = 0, wMin = 0;
		for (int i = 0; i < 6; i++) {
			if(i % 2 == 0) {
//				(0 - 1 + 6) % 6 --> 0때문에 -가 되므로 +6을 해줘야된다.				
//				if(map[(i+1) % 6] + map[(i - 1 + 6) % 6]) 
				if(hMax == map[(i+1) % 6] + map[(i + 5) % 6]) {
					wMin = map[i];
				}
			}else {
				if(wMax == map[(i+1) % 6] + map[(i + 5) % 6]) {
					hMin = map[i];
				}
			}
		}
		
//		System.out.println(wMax + " " + hMax + " " + wMin + " " + hMin );
		int result = 1;
		result = ((wMax * hMax) - (wMin * hMin)) * N;
		System.out.println(result);
	}

}
