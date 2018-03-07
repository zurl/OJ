package leetcode;

public class p387 {

    public int firstUniqChar(String s) {
        int[] cmap = new int[256];
        char[] chars = s.toCharArray();
        for(char c: chars){
            cmap[c]++;
        }
        for(int i = 0; i < chars.length; i++){
            if(cmap[chars[i]] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
