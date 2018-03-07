package leetcode;

import java.util.*;

public class p406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if( o1[0] == o2[0] ) return Integer.compare(o1[1], o2[1]);
                else return -Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        for(int[] p : people){
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        p406 a = new p406();
        System.out.println(a.reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        }));
    }
}
