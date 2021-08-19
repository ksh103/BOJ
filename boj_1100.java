package com.boj;

import java.util.Scanner;

/* boj 1100번 - 하얀 칸 */
public class boj_1100 {
	
	static int SIZE = 8;
	static char[][] charArray = new char[SIZE][SIZE];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < SIZE; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < SIZE; j++) {
				charArray[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				// 짝수 행일때
				if(i%2==0) {
					// 짝수 열에 F가 있는지 확인
					if(j%2==0&&charArray[i][j]=='F') {
						// 있으면 카운트
						count++;
					}
				}
				// 홀수 행일때
				if(i%2==1) {
					// 홀수 열에 F가 있는지 확인
					if(j%2==1&&charArray[i][j]=='F') {
						// 있으면 카운트
						count++;
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
		
}
