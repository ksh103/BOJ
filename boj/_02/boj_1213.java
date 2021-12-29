package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1213번 팰린드롬 만들기 */
public class boj_1213 {

	static int[] alphabet = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();
		
		int len = str.length;
		
		for (int i = 0; i < len; i++) {
			alphabet[str[i] - 65]++;
		}
		
		// 길이가 짝수일 때
		if(len % 2 == 0) {
			if(oddCheck(alphabet) != 0) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			
			for (int i = 0; i < len / 2; i++) {
				
				for (int j = 0; j < 26; j++) {
					if(alphabet[j] != 0 && alphabet[j] % 2 == 0) {
						str[i] = str[len - i - 1] = (char) (j + 65);
						alphabet[j] -= 2;
						break;
					}
				}
			}
		} else { // 길이가 홀수 일 때 
			if(oddCheck(alphabet) != 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			
			int index = 0;
			// 홀수 길이 일 때는 1글자가 남으므로 인덱스값 따로 정의
			for (int i = 0; i < 26; i++) {
				if(alphabet[i] % 2 != 0) index = i;
			}
			
			str[(len - 1) / 2] = (char) (index + 65);
			alphabet[index]--;

			for (int i = 0; i < (len - 1) / 2; i++) {
				for (int j = 0; j < 26; j++) {
					if(alphabet[j] != 0 && alphabet[j] % 2 == 0) {
						str[i] = str[len - i - 1] = (char) (j + 65);
						alphabet[j] -= 2;
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			System.out.print(str[i]);
		}
	}
	
	static int oddCheck(int[] alphabet) {
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if(alphabet[i] % 2 == 1) cnt++;
		}
		return cnt;
	}
}
