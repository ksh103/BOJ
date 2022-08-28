class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split("");
        
        int index = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(" ")) {
                index = 0;
                answer+= " ";
                continue;
            }else if(index % 2 == 0) {
                answer += words[i].toUpperCase();
            }else if(index % 2 != 0) {
                answer += words[i].toLowerCase();
            }
            index++;
        }
        return answer;
    }
}