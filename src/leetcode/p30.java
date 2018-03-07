package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class p30 {


    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        HashMap<String, Integer> currentMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(String word: words){
            wordMap.compute(word, (String key, Integer integer)
                    -> integer == null ? 1 : integer + 1
            );
        }
        int k = words.length, len = words[0].length();
        for(int i = 0; i < len; i++){
            currentMap.clear();
            int l = i, r = i, match = 0;
            while( r + len <= s.length()){
                String sub = s.substring(r, r + len);
                if(wordMap.containsKey(sub)){
                    Integer t = currentMap.get(sub);
                    if( t == null ){
                        currentMap.put(sub, 1);
                        r += len;
                        match ++;
                    }
                    else if( t < wordMap.get(sub) ){
                        currentMap.put(sub, t + 1);
                        r += len;
                        match ++;
                    }
                    else{
                        while( currentMap.get(sub) >= wordMap.get(sub) ){
                            String tstr = s.substring(l, l + len);
                            currentMap.put(tstr, currentMap.get(tstr) - 1);
                            match --;
                            l += len;
                        }
                        currentMap.put(sub, currentMap.get(sub) + 1);
                        r += len;
                        match ++;
                    }
                    if( match == k ){
                        result.add(l);
                        String tstr = s.substring(l, l + len);
                        currentMap.put(tstr, currentMap.get(tstr) - 1);
                        match --;
                        l += len;
                    }
                }
                else{
                    r += len;
                    l = r;
                    match = 0;
                    currentMap.clear();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p30 a= new p30();
        List<Integer> foo = a.findSubstring("aaa", new String[]{"aa", "aa"});
        System.out.println(foo);
    }
}
