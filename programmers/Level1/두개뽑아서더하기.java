import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int result = numbers[i] + numbers[j];
                
                if(!list.contains(result)) list.add(result);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}