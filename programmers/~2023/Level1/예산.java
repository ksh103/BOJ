import java.util.*;

class Solution {
    
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        
        int sum = 0, answer = 0;
        for(int money : d) {
            
            sum += money;
            
            if(sum <= budget) {
                answer++;
            }
        }
        
        return answer;
    }
}