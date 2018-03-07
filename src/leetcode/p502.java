package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p502 {
    public static class MyPair implements Comparable<MyPair>{
        int pro, cap;

        public MyPair(int pro, int cap) {
            this.pro = pro;
            this.cap = cap;
        }

        @Override
        public int compareTo(MyPair o) {
            if( cap == o.cap) return -Integer.compare(pro, o.pro);
            return Integer.compare(cap, o.cap);
        }
    }


    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        MyPair[] pairs = new MyPair[Profits.length];
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = new MyPair(Profits[i], Capital[i]);
        }
        Arrays.sort(pairs);
        PriorityQueue<MyPair> pq = new PriorityQueue<>(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                return -Integer.compare(o1.pro, o2.pro);
            }
        });
        int now = 0;
        while(now < Profits.length && pairs[now].cap <= W) pq.add(pairs[now++]);
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            MyPair p = pq.poll();
            System.out.println("now:" + p.pro);
            W += p.pro;
            while(now < Profits.length && pairs[now].cap <= W) pq.add(pairs[now++]);
        }
        return W;
    }

    public static void main(String[] args) {
        p502 a = new p502();
        System.out.println(a.findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
    }
}
