package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p22 {

    List<String> result;
    char[] buf;
    int len;

    public void dfs(int now, int l, int r){
        if( l == len ){
            for(int j = r; j < len; j++){
                buf[now++] = ')';
            }
            System.out.println(new String(buf));
            result.add(new String(buf));
        }
        else{
            if( l > r ) {
                buf[now] = ')';
                dfs(now + 1, l, r + 1);
            }
            buf[now] = '(';
            dfs(now + 1, l + 1, r);
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        buf = new char[2 * n];
        len = n;
        dfs(0,0, 0);
        return result;
    }

    public static void main(String[] args) {
        (new p22()).generateParenthesis(3);
    }
}
