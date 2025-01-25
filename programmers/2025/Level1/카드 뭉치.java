class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int cardIndex1 = 0;
        int cardIndex2 = 0;
        
        String answer = "Yes";
    
        for (int i = 0; i < goal.length; i++) {
            // 그냥 순차적으로,,, 체크해주면 된다.
            if (cardIndex1 < cards1.length && goal[i].equals(cards1[cardIndex1])) {
                cardIndex1++;
            } else if (cardIndex2 < cards2.length && goal[i].equals(cards2[cardIndex2])) {
                cardIndex2++;
            } else {
                answer = "No";
            }
        }
        
        return answer;
    }
}