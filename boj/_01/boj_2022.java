package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2022번 사다리 */
public class boj_2022 {

	static double x, y, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());
		
		double left = 0, right = Math.min(x, y);
		double result = 0;
		
		while(left + 0.000001 < right) {
			double mid = (left + right) / 2;
			if(getC(mid) >= c) {
				result = mid;
				left = mid + 0.0001;
			}
			else right = mid - 0.0001;
		}
		System.out.printf("%.3f", result);
	}
	
	static double getC(double mid) {
		double X = Math.sqrt(x*x - mid*mid);
		double Y = Math.sqrt(y*y - mid*mid);
		return (X*Y)/(X+Y);
	}
}