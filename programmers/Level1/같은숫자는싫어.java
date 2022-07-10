import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int number = -1; // 0도 배열에 포함될 수 있다.
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != number) {
                list.add(arr[i]);
                number = arr[i];
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}