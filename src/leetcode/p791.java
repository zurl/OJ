package leetcode;


import java.util.Arrays;
import java.util.Comparator;

public class p791 {

    int[] order;

    public String customSortString(String S, String T) {
        order = new int[26];
        char[] s = S.toCharArray();
        for(int i = 0; i < s.length; i++){
            order[s[i] - 'a'] = i;
        }
        char[] t = T.toCharArray();
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t.length - 1; j++){
                if( order[t[j] - 'a'] > order[t[j + 1] - 'a'] ){
                    char a = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = a;
                }
            }
        }
        return new String(t);
    }

    public static void main(String[] args) {
        p791 a = new p791();
        System.out.println(a.customSortString("kqep", "pekeq"));
    }
}
