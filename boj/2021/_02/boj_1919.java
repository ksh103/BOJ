package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1919번 에너그램 만들기 */
public class boj_1919 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine();
		String second = br.readLine();
		
		int[] a = new int[26];
		for (int i = 0; i < first.length(); i++) {
			a[first.charAt(i) - 'a']++;
		}
		
		int[] b = new int[26];
		for (int i = 0; i < second.length(); i++) {
			b[second.charAt(i) - 'a']++;
		}
		
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += Math.abs(a[i] - b[i]);
		}
		System.out.println(sum);
	}
}
