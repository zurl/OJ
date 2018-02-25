package leetcode;

// 0 1 8
// 2 5 6 9
// 3 4 7

public class p788 {

    public boolean isGood(int x){
        String str = Integer.toString(x);
        char[] chars = str.toCharArray();
        int ok = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '3' || chars[i] == '7' || chars[i] == '4' ) return false;
            if(chars[i] == '2' || chars[i] == '5' || chars[i] == '6' || chars[i] == '9') ok = 1;
        }
        return ok == 1;
    }

    public int rotatedDigits(int N) {
        int ret = 0;
       for(int i = 1; i <= N;i ++){
           if(isGood(i)) ret++;
       }
       return ret;
    }

    public static void main(String[] args) {
        new p788().rotatedDigits(100);
    }
}
