package com.boj.im;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2669번 직사각형 네개의 합집합의 면적 구하기 */
public class boj_2669 {

	static int lx, rx, ly, ry, count;
	static boolean[][] select = new boolean[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		count = 0;
		for(int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			rx = Integer.parseInt(st.nextToken());
			ry = Integer.parseInt(st.nextToken());
			
			for (int x = lx; x < rx; x++) {
				for (int y = ly; y < ry; y++) {
					if(!select[x][y]) {
						select[x][y] = true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
