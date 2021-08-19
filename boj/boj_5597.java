package com.boj;

import java.util.Scanner;

/* boj 5597번 과제 안 내신 분..? */
public class boj_5597{
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int[] student = new int[31];
		
		for(int i = 1; i <= 28; i++) {
			int st = sc.nextInt();
			student[st] = 1;
		}
		
		for(int i = 1; i <= 30; i++) {
			if(student[i] == 0) {
				System.out.println(i);
			}
		}

	}

}
