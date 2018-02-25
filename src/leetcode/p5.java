package leetcode;

public class p5 {
    public String longestPalindrome(String s) {
        int maxn = Integer.MIN_VALUE, maxl = 0, maxr = 0, j;
        for(int i = 0; i < s.length(); i++){
            j = 0;
            while(i - j >= 0 && i + j < s.length()
                    && s.charAt(i + j) == s.charAt(i - j)) j++;
            j--;
            if( 2 * j + 1 > maxn ){
                maxn = 2 * j + 1;
                maxl = i - j;
                maxr = i + j;
            }
            if( i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)){
                j = 0;
                while(i - j >= 0 && i + j + 1 < s.length()
                        && s.charAt(i + j + 1) == s.charAt(i - j)) j++;
                if( 2 * j > maxn ){
                    maxn = 2 * j;
                    maxl = i - j + 1;
                    maxr = i + j;
                }
            }
        }
        return s.substring(maxl, maxr + 1);
    }

    public static void main(String[] args) {
        p5 p = new p5();
        System.out.println(p.longestPalindrome("a"));
    }
}
