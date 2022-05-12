import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        char[] input = String.valueOf(n).toCharArray();
        
        for(int i = 0; i < input.length; i++) {
            answer += input[i] - '0';
        }

        return answer;
    }
}