package leetcode;

public class p7 {

    public int reverse(int x) {
        long result = Long.parseLong(
                new StringBuilder(Long.toString(
                        Math.abs((long)x))).reverse().toString());
        if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ) return 0;
        if( x > 0 ) return (int)result;
        else return -(int)result;
    }


    public static void main(String[] args) {
        System.out.println(new p7().reverse(-2147483648));
    }
}
