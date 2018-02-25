package leetcode;


import java.util.HashMap;

public class p781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < answers.length; i++){
            Integer ret = map.get(answers[i]);
            if( ret == null){
                map.put(answers[i], 1);
            }
            else{
                map.put(answers[i], ret + 1);
            }
        }
        int result = 0;
        for( Integer i : map.keySet()){
            int val = map.get(i);
            int group = (int) Math.ceil( val * 1.0 / (i + 1));
            result += group * (i + 1);
        }
        return result;
    }

}

/*
1, 1 => 2
1, 2 => 2
1, 3 => 4
1, 4 => 4

2, 1 => 3
2, 2 => 3
2, 3 => 3


 */