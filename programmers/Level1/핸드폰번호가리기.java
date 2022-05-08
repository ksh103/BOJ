class Solution {
    public String solution(String phone_number) {
        String start_number = "";
        String end_number = "";
        
        for(int i = 0; i < phone_number.length() - 4; i++) {
            start_number += "*";
        }
        
        end_number = phone_number.substring(phone_number.length() - 4, phone_number.length());
        
        return start_number + end_number;
    }
}