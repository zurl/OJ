package leetcode;

import java.util.Arrays;

public class p447 {

    public int numberOfBoomerangs(int[][] points) {
        int[] dis = new int[points.length];
        int result = 0;
        for(int[] src: points){
            int sx = src[0], sy = src[1];
            for(int i = 0; i < dis.length; i++){
                int dx = points[i][0], dy = points[i][1];
                dis[i] = (dx - sx) * (dx - sx) + (dy - sy) * (dy - sy);
            }
            Arrays.sort(dis);
            int same = 0;
            for(int i = 1; i <= dis.length; i++){
                if( i == dis.length || dis[i] != dis[i - 1]){
                    if( same != 0 ){
                        result += same * (same + 1) ;
                    }
                    same = 0;
                }
                else{
                    same ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p447 a = new p447();
        System.out.println(a.numberOfBoomerangs(new int[][]{
                {0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}
        }));
    }
}
