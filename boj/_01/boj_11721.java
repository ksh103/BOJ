package com.boj;

import java.util.Scanner;

/* boj 11721번 - 열 개씩 끊어 출력하기 */
public class boj_11721 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int i = 0; i<str.length(); i++) {
			System.out.print(str.charAt(i));
			if(i%10 == 9) {
				System.out.println();
			}
		}
		sc.close();
	}
}
