package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p500 {

    int[] line;

    void init(){
        line = new int[256];
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm" };
        for(int i = 0; i < lines.length; i++){
            char[] chars = lines[i].toCharArray();
            for(char c : chars){
                line[c] = i;
                line[c - 'a' + 'A'] = i;
            }
        }
    }

    public String[] findWords(String[] words) {
        if( line == null )init();
        List<String> result = new ArrayList<>();
        for(String w : words){
            if( w.equals("") ){
                result.add(""); continue;
            }
            char[] chars = w.toCharArray();
            int ok = 1, c0 = line[chars[0]];
            for(char c : chars){
                if( line[c] != c0){ ok = 0; break;}
            }
            if( ok == 1) result.add(w);
        }
        return result.toArray(new String[result.size()]);
    }
}
