import java.util.*;

class Solution {
    
    public int solution(int n) {
        boolean[] prime = new boolean[n + 1];
        int answer = 0;
        
        isPrime(prime, n);
        
        for(int i = 2; i <= n; i++) {
            if(prime[i]) answer++;
        }
        return answer;
    }
    
    public void isPrime(boolean[] prime, int n) {
        Arrays.fill(prime, true);
        
        for(int i = 2; i * i <= n; i++){
            for(int j = i * i; j <= n; j+=i) {
                prime[j] = false;
            }
        }
    }
}