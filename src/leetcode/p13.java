package leetcode;

public class p13 {

    final static String[] a0 = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    final static String[] a1 = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    final static String[] a2 = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    final static String[] a3 = {"","M","MM","MMM"};

    public int findIx(String[] arr, String str){
        for(int i = 0; i < 10; i++) if( arr[i].equals(str) ) return i;
        return -1;
    }

    public int romanToInt(String s) {
        int i = 0, i0, i1, i2;
        char[] chars = s.toCharArray();
        while(i < chars.length && chars[i] == 'M') i++;
        i2 = i;
        while(i < chars.length && chars[i] != 'X' && chars[i] != 'L' && chars[i] != 'I' && chars[i] != 'V') i++;
        i1 = i;
        while(i < chars.length && chars[i] != 'I' && chars[i] != 'V') i++;
        i0 = i;
        int r0 = findIx(a0, s.substring(i0, s.length()));
        int r1 = findIx(a1, s.substring(i1, i0));
        int r2 = findIx(a2, s.substring(i2, i1));
        int r3 = findIx(a3, s.substring(0, i2));
        System.out.println(r0 + " " + r1 + " " + r2 + " " + r3);
        return r0 + r1 * 10 + r2 * 100 + r3 * 1000;
    }

    public static void main(String[] args) {
        p13 a = new p13();
        System.out.println(a.romanToInt("MLXXIV"));
    }

}
