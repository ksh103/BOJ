class Solution {
    
    static String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    static int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String solution(int a, int b) {
        
        int date = 0;
        for(int i = 0; i < a - 1; i++) {
            date += day[i];
        }
        
        date += b - 1;
        
        return week[date % 7];
    }
}