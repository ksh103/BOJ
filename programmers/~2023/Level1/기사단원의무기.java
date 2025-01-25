class Solution {
    public int solution(int number, int limit, int power) {

        int answer = 0;
        for(int n = 1; n <= number; n++) {
            int count = 0;
            for(int i = 1; i * i <= n; i++) {
                if(n % i == 0) {
                    count++;
                    
                    if(i * i < n) {
                        count++;
                    }
                }
            }
            if(count <= limit) answer += count;
            else answer += power;
        }
        
        return answer;
    }
}