package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/* boj 7785번 회사에 있는 사람 */
public class boj_7785 {

	static int n;
	static HashMap<String, String> map = new HashMap<String, String>();
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			map.put(name, state);
		}
		
		office(map);
	}
	
	static void office(HashMap<String, String> map) {
		for (Entry<String, String> tmp : map.entrySet()) {
			if(tmp.getValue().equals("enter")) {
				list.add(tmp.getKey());
			}
		}
		
		list.sort(Collections.reverseOrder()); // 사전 역순
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
