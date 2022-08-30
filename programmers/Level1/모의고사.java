import java.util.*;

class Solution {
    
    static int[] one = {1, 2, 3, 4, 5}; // 수포자 1
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 수포자 2
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 수포자 3

    static int[] count = new int[3];
    
    public int[] solution(int[] answers) {
        
        for(int i = 0; i < answers.length; i++) {
            int score = answers[i];
            
            if(one[i % one.length] == score) count[0]++;
            if(two[i % two.length] == score) count[1]++;
            if(three[i % three.length] == score) count[2]++;
        }
        
        int maxScore = Arrays.stream(count).max().getAsInt(); // 가장 높은 점수
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            if(maxScore == count[i]) {
                list.add(i + 1);
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}