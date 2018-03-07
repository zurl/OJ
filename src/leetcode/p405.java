package leetcode;

public class p405 {
    public String toHex(int num) {
        if( num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        long val = num;
        if( val < 0 ) val = Integer.MAX_VALUE + val + 0x80000001L;
        while(val > 0){
            if( val % 16 >= 10){
                sb.append( (char)(val % 16 - 10 + 'a'));
            }
            else{
                sb.append( (char)(val % 16 + '0'));
            }
            val /= 16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        p405 a = new p405();
        System.out.println(a.toHex(-123) + "," + Integer.toString(-1, 16));
    }
}
