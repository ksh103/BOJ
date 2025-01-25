class Solution {
    
    static int SIZE, answer;
    static int[] number, arr;
    
    public int solution(int[] number) {
        this.SIZE = number.length;
        this.number = number;
        
        arr = new int[3]; // 삼총사 배열
        answer = 0;
        
        solve(0, 0);
        
        return answer;
    }
    
    private static void solve(int depth, int index) {
        int sum = 0;
        
        if(depth == 3) {
            // 삼총사 합 구하기
            for(int n : arr) {
                sum += n;
            }
            
            // 합이 0이면 삼총사를 만들 수 있음
            if(sum == 0) answer++;
            
            return;
        }
        
        for(int i = index; i < SIZE; i++) {
            arr[depth] = number[i];
            solve(depth + 1, i + 1);
        }
    }
}