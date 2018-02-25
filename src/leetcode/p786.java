package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return A[o1[0]] * A[o2[1]] - A[o1[1]] * A[o2[0]];
            }
        });
        for(int i = 0; i < A.length; i++){
            pq.offer(new int[]{i, A.length - 1});
        }
        for(int i = 0; i < K - 1; i++){
            int[] item = pq.poll();
            if( item[0] < item[1] - 1){
                pq.offer( new int[]{ item[0], item[1] - 1});
            }
        }
        return new int[]{A[pq.peek()[0]], A[pq.peek()[1]]};
    }
}
