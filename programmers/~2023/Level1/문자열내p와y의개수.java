class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0, yCnt = 0;

        for(int i = 0; i < s.length(); i++) {
            char eng = s.charAt(i);
            
            if(eng == 'p' || eng == 'P') pCnt++;
            else if (eng == 'y' || eng == 'Y') yCnt++;
        }
        
        if(pCnt != yCnt) answer = false;
        else answer = true;
        
        return answer;
    }
}