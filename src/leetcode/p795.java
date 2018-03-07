package leetcode;

public class p795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int l = 0, ans = 0, last = -1;
        for(int i = 0; i <= A.length; i++){
            if( i == A.length || A[i] > R) {
                System.out.println("l=" + l + ",r=" + i);
                for(int j = l; j < i; j ++){
                    if( A[j] >= L && A[j] <= R){
                        System.out.println(j + ", last = " + last);
                        ans += ( j - last) * ( i - j);
                        last = j;
                    }
                }
                l = i + 1;
                last = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        p795 a = new p795();
        System.out.println(a.numSubarrayBoundedMax(new int[]{2,9,2,5,6}, 2, 8));
    }
}
