class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = i; j <= n; j++) {
                sum += j;
                
                if(sum == n) {
                    answer++;
                    break;
                } else if (sum > n) { // 합 > n 조건을 넣어야 시간 초과가 안 남.
                    break;
                }
            }
        }
        return answer;
    }
}