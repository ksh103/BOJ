class Solution {
    public int[] solution(long n) {
        
        char[] numbers = String.valueOf(n).toCharArray();
        int size = numbers.length;
        
        int[] answer = new int[size];
        
        for(int i = size - 1; i >= 0; i--) {
            answer[size - i - 1] = numbers[i] - '0';
        }
        return answer;
    }
}