package leetcode;

import java.util.HashMap;

public class p446 {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        HashMap<Long, Integer>[] hm = new HashMap[A.length];
        for(int i = 0; i < A.length; i++){
            hm[i] = new HashMap<>();
            for(int j = 0; j < i; j ++){
                long delta = (long)A[i] - (long)A[j];
                Integer hj = hm[j].get(delta);
                Integer hi = hm[i].get(delta);
                if( hj == null ){
                    if( hi == null ) hm[i].put(delta, 1);
                    else hm[i].put(delta, hi + 1);
                }
                else{
                    result += hj;
                    if( hi == null ) hm[i].put(delta, hj + 1);
                    else hm[i].put(delta, hi + hj + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p446 a = new p446();
        System.out.println(a.numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
    }
}
