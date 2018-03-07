package leetcode;

public class p14 {
    public String longestCommonPrefix(String[] strs) {
        if( strs.length == 0) return "";
        char[] prefix = strs[0].toCharArray();
        int len = prefix.length;
        for(String x: strs){
            char[] xa = x.toCharArray();
            int samelen = 0;
            while(samelen < xa.length && samelen < len && xa[samelen] == prefix[samelen]) samelen++;
            if( samelen < len) len = samelen;
        }
        return new String(prefix).substring(0, len);
    }

    public static void main(String[] args) {
        p14 a = new p14();
        System.out.println(a.longestCommonPrefix(new String[]{"12345", "123", "125", "1234"}));
    }
}
