package com.boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1541번 잃어버린 괄호 */
public class boj_1541 {

	static String input;
	static String[] subArr, plusArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		// split 해줄 때 \\를 해주는 이유는 정규 표현식에서 사용되는 문자들이기 때문에 문자 그자체로 인식하게 하기 위함
		subArr = input.split("\\-");
		
		// subArr[0]은 +기호가 속한 수식
		int sub = add(subArr[0]);
		
		// - 기호가 속한 수식 계산
		for(int i = 1; i < subArr.length; i++) {
			sub -= add(subArr[i]);
		}
		
		System.out.println(sub);
	}
	
	//+ 기호가 속한 수식 계산
	public static int add(String input) {
		int sum = 0;
		plusArr = input.split("\\+");
		for(int i = 0; i < plusArr.length; i++) {
			sum += Integer.parseInt(plusArr[i]);
		}
		return sum;
	}
}