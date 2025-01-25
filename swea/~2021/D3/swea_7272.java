package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 7272번 안경이 없어! (D3) */
public class swea_7272 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String a = st.nextToken();
			String b = st.nextToken();
			
			System.out.print("#" + t + " ");
			if(text(a).equals(text(b))) {
				System.out.println("SAME");
			}else {
				System.out.println("DIFF");
			}
		}
	}
	/* 조건)
	 * 구멍이 하나도 없는 CEFGHIJKLMNSTUVWXYZ들을 같은 문자로 생각
	 * 구멍이 한 개 나 있는 ADOPQR들을 같은 문자로 생각
	 * 구멍이 두 개 나 있는 유일한 문자 B는 유일하게 정확히 알 수 있다. --> 굳이 다른 문자로 바꿀 필요 x
	 */
	static String text(String text) {
		text = text.replaceAll("C|E|F|G|H|I|J|K|L|M|N|S|T|U|V|W|X|Y|Z", ".");
		text = text.replaceAll("A|D|O|P|Q|R", "-");
		
		return text;
	}
}
