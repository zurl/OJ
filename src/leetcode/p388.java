package leetcode;

public class p388 {

    public int lengthLongestPath(String input) {
        char[] chars = input.toCharArray();
        int[] len = new int[65535];
        int last = 0, isDict = 1, deep = 0, onRec = 1, maxn = 0;
        for(int i = 0; i <= chars.length; i++){
            if(i == chars.length || chars[i] == '\n'){
                len[deep] = i - last - deep;
                if( isDict == 0) {
                    int sum = 0;
                    for (int j = 0; j <= deep; j++) {
                        sum += len[j] + 1;
                    }
                    sum--;
                    maxn = Math.max(sum, maxn);
                }
                last = i + 1;
                isDict = 1;
                deep = 0;
                onRec = 1;
                continue;
            }
            if( chars[i] == '.'){
                isDict = 0;
            }
            if( chars[i] == '\t' && onRec == 1){
                deep ++;
            }
            else{
                onRec = 0;
            }
        }
        return maxn;
    }

    public static void main(String[] args) {
        p388 aa = new p388();
        System.out.println(aa.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}
