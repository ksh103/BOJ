class Solution {
    
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        target(numbers, target, 0, 0);
        
        return answer;
    }
    
    private void target(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            // 숫자들의 합과 타켓 넘버가 같으면 카운트
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        target(numbers, target, depth + 1, sum + numbers[depth]); // 덧셈
        target(numbers, target, depth + 1, sum - numbers[depth]); // 뺄셈
    }
}