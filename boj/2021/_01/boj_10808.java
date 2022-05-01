package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10808번 알파벳 개수 */
public class boj_10808 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int[] cnt = new int[26];
		char ch = 'a';
		
		for (int i = 0; i < input.length(); i++) {
			cnt[input.charAt(i) - ch]++;
			
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}
