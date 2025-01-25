class Solution {

	// n = 1 → 1
	// n = 2 → 2
	// n = 3 → 3
	// n = 4 → 5
	// n = 5 → 8
    public long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] += (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        
        answer = dp[n];
        
        return answer;
    }
}