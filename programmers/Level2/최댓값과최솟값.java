class Solution {
    public String solution(String s) {

        String[] numbers = s.split(" ");
    
        int max, min;
        max = min = Integer.parseInt(numbers[0]);

        for(int i = 1; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return Integer.toString(min) + " " + Integer.toString(max);
    }
}