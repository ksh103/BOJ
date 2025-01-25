class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0, win = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zero++;
            else {
                for(int j = 0; j < win_nums.length; j++) {
                    if(lottos[i] == win_nums[j]) {
                        win++;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        
        int min_score = win;
        int max_score = win + zero;
        
        answer[0] = max_score == 0 ? 6 : 7 - max_score;
        answer[1] = min_score == 0 ? 6 : 7 - min_score;
        
        return answer;
    }
}