package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p763 {
    public List<Integer> partitionLabels(String S) {
        int[] index = new int[100];
        char[] chars = S.toCharArray();
        for(int i = 0; i < chars.length; i++){
            index[chars[i] - 'a'] = i;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int l = 0, minr = index[chars[0] - 'a'];
        for(int i = 0; i < chars.length; i++){
            if( i == minr ){
                //System.out.println("split:" + S.substring(l, i + 1));
                result.add( i - l + 1);
                if( i + 1 >= chars.length) break;
                l = i + 1;
                minr = index[chars[i + 1] - 'a'];
            }
            else{
                minr = Math.max(minr, index[chars[i] - 'a']);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p763 a = new p763();
        System.out.println(a.partitionLabels("caedbdedda"));
    }
}
