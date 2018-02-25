package leetcode;

public class p3 {
    int[] has;

    public int lengthOfLongestSubstring(String s) {
        has = new int[256];
        int l = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while( has[c] != 0 ){
                has[s.charAt(l)] --;
                l ++;
            }
            has[c]++;
            result = Math.max(result, i - l + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        p3 a = new p3();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring("bbbbb"));
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
    }
}
