package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2628번 종이자르기 */
public class boj_2628 {

	static int x, y, n;
	static int[] cutRow, curCol, reRow, reCol;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken()); // 종이의 가로
		y = Integer.parseInt(st.nextToken()); // 종이의 세로
		
		n = Integer.parseInt(br.readLine()); // 칼로 잘라야 하는 점선의 개수
		
		cutRow = new int[n+1]; // 가로로 자르는 점선
		curCol = new int[n+1]; // 세로로 자르는 점선
		reRow = new int[n+1];
		reCol = new int[n+1];
		
		cutRow[n] = y;
		curCol[n] = x;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cutType = Integer.parseInt(st.nextToken()); // 가로 0, 세로 1
			int cutNum = Integer.parseInt(st.nextToken());
			
			if(cutType == 0) cutRow[i] = cutNum;
			else curCol[i] = cutNum;
		}
		
		// 정렬 시키기
		Arrays.sort(cutRow);
		Arrays.sort(curCol);
		
		for (int i = 1; i <= n; i++) {
			reRow[i] = cutRow[i] - cutRow[i-1];
			reCol[i] = curCol[i] - curCol[i-1];
		}
		
		// 자른 종이 정렬
		Arrays.sort(reRow);
		Arrays.sort(reCol);
		
		System.out.println(reRow[n] * reCol[n]);
	}
}
