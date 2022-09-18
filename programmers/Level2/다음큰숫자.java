class Solution {

    public int solution(int n) {

        String num = Integer.toString(n, 2);
        
        int numCount = 0;
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '1') numCount++;
        }
        
        int answer = 0;
        
        while(true) {
            n++;
            
            String temp = Integer.toString(n, 2);
            
            int tempCount = 0;
            for(int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == '1') tempCount++;
            }
            
            if(tempCount == numCount) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}