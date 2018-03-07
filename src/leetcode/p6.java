package leetcode;

public class p6 {

    public String convert(String s, int numRows) {
        if( numRows == 1) return s;
        char[] src = s.toCharArray();
        char[] dst = new char[src.length];
        int T = 2 * numRows - 2;
        int now = -1;
        for(int i = 1; i <= numRows; i++){
            int t = numRows - i;
            for(int j = i - 1; j < src.length; j += T){
                dst[++now] = src[j];
                if( i != 1 && t != 0 && j + t * 2 < src.length){
                    dst[++now] = src[j + t * 2];
                }
            }
        }
        return new String(dst);
    }

    public static void main(String[] args) {
        p6 a = new p6();
        System.out.println(a.convert("A", 1));
    }
}
