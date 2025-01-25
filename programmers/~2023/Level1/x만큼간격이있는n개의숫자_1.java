class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        long res = 0;
        
        answer = new long[n];

        for(int i = 0; i < n; i++) {
            res += x;
            answer[i] = res;
        }
        
        return answer;
    }
}