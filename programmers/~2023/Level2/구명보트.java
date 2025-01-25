import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int index = 0;
        for(int i = people.length - 1; i > index; i--) {
            if(people[index] + people[i] <= limit) {
                index++;
            }
        }
        
        return (people.length - index);
    }
}