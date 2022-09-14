package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 17271번 리그 오브 레전설 (Small) */
public class boj_17271 {

	static int[] dp;
	static int N, M;
	static final int INF = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      StringTokenizer st = new StringTokenizer(br.readLine());
	      
	      N = Integer.parseInt(st.nextToken());
	      M = Integer.parseInt(st.nextToken()); // B 스킬의 시전 시간
	      
	      dp = new int[N + 1];
	      
	      dp[0] = 1;
	      
	      for(int i = 1; i <= N; i++) {
	    	  // A스킬 시전 1초
	    	  dp[i] = dp[i - 1];
	    	  
	    	  // B스킬 시전 M초
	    	  if(i >= M) dp[i] += dp[i - M];
	    	  
	    	  dp[i] %= INF;
	      }
	      
	      System.out.print(dp[N]);
	}
}
