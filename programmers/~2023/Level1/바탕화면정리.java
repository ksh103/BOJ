class Solution {
    public int[] solution(String[] wallpaper) {

        int R = wallpaper.length;
        int C = wallpaper[0].length();
        
        char[][] map = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            map[i] = wallpaper[i].toCharArray();
        }
        
        int lux = 50, luy = 50, rdx = 0, rdy = 0;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '#') {
                    lux = lux > i ? i : lux;
                    luy = luy > j ? j : luy;
                    rdx = rdx < i ? i : rdx;
                    rdy = rdy < j ? j : rdy;
                }
            }
        }
        
        return new int[] {lux, luy, rdx + 1, rdy + 1};
    }
}