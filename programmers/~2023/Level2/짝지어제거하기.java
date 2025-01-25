import java.util.*;

class Solution {
    
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();
        
        char[] chArr = s.toCharArray();
        
        for(char ch : chArr) {
            // 스택이 비어 있다면 문자열 추가
            if(stack.isEmpty()) {
                stack.push(ch);
            } else {
                // 스택에 있는 문자열이 비교하고자 하는 문자열과 같을 때
                if(stack.peek() == ch) {
                    // 해당 문자열 제거
                    stack.pop();
                } else {
                    // 문자열 추가
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}