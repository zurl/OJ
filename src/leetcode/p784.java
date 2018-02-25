package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p784 {

    char[] s;
    List<String> result;

    public void dfs(int now){
        if( now == s.length){
            result.add(new String(s));
            return;
        }
        if( s[now] >= 'a' && s[now] <= 'z'){
            dfs(now + 1);
            s[now] = (char)(s[now] - 'a' + 'A');
            dfs(now + 1);
        }
        else if( s[now] >= 'A' && s[now] <= 'Z'){
            dfs(now + 1);
            s[now] = (char)(s[now] - 'A' + 'a');
            dfs(now + 1);
        }
        else dfs(now + 1);
    }

    public List<String> letterCasePermutation(String S) {
        result = new ArrayList<>();
        s = S.toCharArray();
        dfs(0);
        return result;
    }

    public static void main(String[] args) {
        p784 a = new p784();
        System.out.println(a.letterCasePermutation("a1b2"));
    }

}
