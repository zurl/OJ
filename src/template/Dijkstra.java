package template;

import leetcode.p787;

import java.util.PriorityQueue;

public class Dijkstra {
    static class Edge{
        int v, t;
        Edge prev;
        Edge(int t, int v, Edge prev){
            this.v = v;
            this.t = t;
            this.prev = prev;
        }
    }

    Edge[] edges;

    static class Item implements Comparable<Item>{
        int p, v;

        Item(int p, int v){
            this.p = p;
            this.v = v;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(v, o.v);
        }
    }

    public int dijkstra(int st, int ed, int n){
        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.add(new Item(st, 0));
        int[] dis = new int[n];
        for(int i = 0; i < n; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[st] = 0;
        while(!pq.isEmpty()){
            Item item = pq.poll();
            for(Edge e = edges[item.p]; e != null; e = e.prev){
                if( dis[e.t] >= dis[item.p] + e.v){
                    dis[e.t] = dis[item.p] + e.v;
                    pq.add(new Item(e.t, dis[e.t]));
                }
            }
        }
        if(dis[ed] == Integer.MAX_VALUE) return -1;
        return dis[ed];
    }
}
