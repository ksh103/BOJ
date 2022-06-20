import java.util.*;

class Solution {
    public long solution(long n) {

        char[] array = String.valueOf(n).toCharArray();
        
        Arrays.sort(array);
        
        String answer = "";
        for(int i = array.length - 1; i >= 0; i--) {
           answer += array[i];
        }
        
        return Long.parseLong(answer);
    }
}