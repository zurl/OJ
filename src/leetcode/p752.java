package leetcode;

import java.util.*;

public class p752 {

    static class Item{
        char[] lock;
        int iter;

        public Item(char[] lock, int iter) {
            this.lock = lock;
            this.iter = iter;
        }
    }

    public int openLock(String[] deadends, String target) {
        Queue<Item> queue = new ArrayDeque<>();
        queue.add(new Item("0000".toCharArray(), 0));
        HashSet<String> deadset = new HashSet<>(Arrays.asList(deadends));
        while(!queue.isEmpty()){
            Item now = queue.poll();
            for(int i = 0; i < 4; i++){
                now.lock[i] = (char)((now.lock[i] + 1 - '0') % 10 + '0');
                String str = new String(now.lock);
                if(str.equals(target)){
                    return now.iter + 1;
                }
                if( !deadset.contains(str) ){
                    deadset.add(str);
                    queue.add(new Item(now.lock.clone(), now.iter + 1));
                }
                now.lock[i] = (char)((now.lock[i] - 2 - '0' + 10) % 10 + '0');
                str = new String(now.lock);
                if(str.equals(target)){
                    return now.iter + 1;
                }
                if( !deadset.contains(str) ){
                    deadset.add(str);
                    queue.add(new Item(now.lock.clone(), now.iter + 1));
                }
                now.lock[i] = (char)((now.lock[i] + 1 - '0') % 10 + '0');
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        p752 a = new p752();
        System.out.println(a.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }


}
