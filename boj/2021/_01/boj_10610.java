package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* boj 10610번 30 */
public class boj_10610 {

	/* 30배수 확인 방법
	 * 10의 배수는 일의 자리가 0이어야 됨.
	 * 3의 배수인지 확인 -> 각 자리수 더한 값이 3의 배수
	 */
	static String[] str;
	static int sum;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		str = br.readLine().split("");
		
		// 가장 큰수를 만들어야하므로 내림차순  정렬
		Arrays.sort(str, Collections.reverseOrder());
		
		sum = 0;
		// 3의 배수 판별을 위해 각 자리수 더하기
		for(int i = 0; i < str.length; i++) {
			int num = Integer.parseInt(str[i]);
			sum += num; 
			sb.append(num);
		}	

		// 30배수인지 아닌지 판별
		// 일의 자리 수가 0, 각 자리수 합계가 3의 배수인지 
		if(str[str.length -1].equals("0") && sum % 3 == 0) {
			System.out.println(sb.toString());
		}else System.out.println("-1");

	}
}
