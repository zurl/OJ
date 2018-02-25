package leetcode;

public class p789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = target[0] + target[1];
        for(int i = 0; i < ghosts.length; i++){
            int d = Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]);
            if( d <= dis){
                return false;
            }
        }
        return true;
    }
}
