package leetcode;

import java.util.*;

public class p386 {

    ArrayList<Integer> result;
    int n, len;

    void dfs(int deep, int prefix, int st){
        if( deep > len ) return;
        for(int i = st; i < 10; i ++){
            int now = prefix * 10 + i;
            if( now > n ) return;
            result.add(now);
            dfs(deep + 1, now, 0);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>(n);
        len = Integer.toString(n).length();
        this.n = n;
        dfs(0, 0, 1);
        return result;
    }

    public static void main(String[] args) {
        p386 a = new p386();
        a.lexicalOrder(999);
    }
}
