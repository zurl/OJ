package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class p452 {


    public int findMinArrowShots(int[][] points) {
        if( points.length == 0 ) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int result = 1, now = points[0][1];
        for(int[] point: points){
            if( point[0] <= now ) continue;
            else {
                result ++;
                now = point[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p452 a = new p452();
        System.out.println(a.findMinArrowShots(new int[][]
                {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}
                ));
    }
}
