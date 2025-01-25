class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // 공백이면 그대로 공백 저장
            if(ch == ' ') {
                answer += ' ';
                continue;
            } 
        
            if(ch >= 'A' && ch <= 'Z') {
                
                // ex) ch == 'A' (65)
                // 'A'(65) - 'A'(65) + n(얼마나 밀것인지) => 나머지 연산 후 'A' 더해줌
                answer += (char) ((ch - 'A' + n) % 26 + 'A');
            }else if(ch >= 'a' && ch <= 'z') {
                answer += (char) ((ch - 'a' + n) % 26 + 'a');
            }
        }
        return answer;
    }
}