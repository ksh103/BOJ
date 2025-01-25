import java.util.*;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] answer;
    public int[] solution(int[] arr, int divisor) {

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        if(list.isEmpty()) {
            list.add(-1);
        } 
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}