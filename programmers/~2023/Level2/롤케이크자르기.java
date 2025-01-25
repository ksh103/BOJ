import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        int N = topping.length;
        
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();
            
        int[] left = new int[N];
        int[] right = new int[N];
        
        for(int i = 0; i < N; i++) {
            leftSet.add(topping[i]);
            rightSet.add(topping[N - i - 1]);
            
            left[i] = leftSet.size();
            right[N - i - 1] = rightSet.size();
        }
        
        int answer = 0;
        for(int i = 0; i < N - 1; i++) {
            if(left[i] == right[i + 1]) {
                answer++;
            }
        }
        return answer;
    }
}