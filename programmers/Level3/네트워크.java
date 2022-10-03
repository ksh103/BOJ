class Solution {
    
    static int n;
    static int[][] computers;
    static boolean[] flag;
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        flag = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!flag[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int node) {
        flag[node] = true;
        
        for(int i = 0 ; i < computers.length; i++) {
            if(flag[i] || computers[node][i] != 1) continue;
            
            dfs(i);
        }
    }
}