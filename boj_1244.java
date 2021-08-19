package com.boj;

import java.io.IOException;
import java.util.Scanner;

/* boj 1244번 스위치 켜고 끄기 */
public class boj_1244 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int SIZE = sc.nextInt(); // 배열 크기
		int[] switchArr = new int[SIZE + 1]; // 스위치 배열 선언
		
		for(int i = 1; i <= SIZE; i++) {
			switchArr[i] = sc.nextInt(); 
		}
		
		int n = sc.nextInt(); // 사람 수
		
		while(n-->0) {
			int sex = sc.nextInt(); // 성별
			int idx = sc.nextInt(); // 인덱스 값
			
			// 남자
			if(sex == 1) {
				int save = idx; // 입력 받은 숫자에 대한 배수 값들의 스위치 값을 변경하기 위해 인덱스 값 따로 저장
				// 인덱스 범위를 SIZE 크기를 포함하지 않아서 반례에서 오류남.
				while(idx <= SIZE) {
					switchArr[idx]^=1; // XOR 연산
					idx+=save; 
				}
			// 여자 
			}else if(sex == 2) {
				switchArr[idx]^=1; // 기준이 되는 값은 무조건 바꿈
				int left  = idx - 1; // 왼쪽
				int right = idx + 1; // 오른쪽
				// 범위를 벗어나는지 확인 + 좌우대칭 확인
				while(left > 0 && right <= SIZE && (switchArr[left]==switchArr[right])) {
					// XOR 연산
					switchArr[left]^=1; 
					switchArr[right]^=1;
					left--; 
					right++;
				}
			}
		}
		for(int i = 1; i <= SIZE; i++) {
			System.out.print(switchArr[i] + " ");
			// 20줄이 넘으면 21번째부터 다음 줄에 출력
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}
}

/* 반례 확인
25
0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0
1
1 1
*/