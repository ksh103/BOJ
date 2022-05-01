package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 13300번 방 배정 */
public class boj_13300 {

	static int N, K, S, grade;
	static int[][] student;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수학 여행을 참가하는 학생 수
 		K = Integer.parseInt(st.nextToken()); // 한 방에 배정할 수 있는 최대 수
 		
 		student = new int[2][7];
 		
 		for(int i = 1; i <= N; i++) {
 			st = new StringTokenizer(br.readLine());
 			
 			S = Integer.parseInt(st.nextToken()); // 성별 --> 여학생 : 0, 남학생 : 1
 			grade = Integer.parseInt(st.nextToken()); // 학년

 			student[S][grade]++;
 			
// 			if(S == 0) {
// 				student[0][grade]++;
// 			}else if(S == 1) {
// 				student[1][grade]++;
// 			}
 		}
 		
 		
 		int room = 0;
 		for(int i = 0; i < 2; i++) {
 			for(int j = 1; j <= 6; j++) {
 				// room += Math.ceil(student[i][j] / (double) K);
 				// room += (student[i][j] + K - 1) / K;
 				if(student[i][j] % K == 0) {
 					room += student[i][j] / K;
 				}else {
 					room += student[i][j] / K + 1;
 				}
 			}
 		}
 		
// 		int room = 0;
// 		for(int i = 1; i <= 6; i++) { 		
// 			if(student[0][i] % K == 0) {
// 				room += student[0][i] / K;
// 			}else {
// 				room += student[0][i] / K+1;
// 			}
// 		}
// 		
// 		// 남학생 방
// 		for(int i = 1; i <= 6; i++) {
// 			if(student[1][i] % K == 0) {
// 				room += student[1][i] / K;
// 			}else {
// 				room += student[1][i] / K+1;
// 			}
// 		}
 		System.out.println(room);
	}
}
