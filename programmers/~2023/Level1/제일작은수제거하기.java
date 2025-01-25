import java.util.*;
import java.lang.*;

class Solution {
    
    static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) {
            int[] answer =  {-1};
            return answer;
        }
        
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        Arrays.sort(arr);
        
        list.remove(list.indexOf(arr[0]));
        
        int[] answer = new int[arr.length - 1];
                    
        for(int i = 0; i < arr.length - 1; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}