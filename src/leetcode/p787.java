package leetcode;

import java.util.PriorityQueue;

public class    p787 {

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

    public int getPoint(int layer, int point, int n){
        return layer * n + point;
    }

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

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        edges = new Edge[n * (K + 2)];
        for(int i = 0; i < flights.length; i++){
            int s = flights[i][0];
            int t = flights[i][1];
            int v = flights[i][2];
            for(int j = 0; j <= K ; j++){
                int ks = getPoint(j, s, n);
                int kt = getPoint(j + 1, t, n);
                edges[ks] = new Edge(kt, v, edges[ks]);
            }
        }
        for(int i = 0; i <= K; i++){
            int s = getPoint(i, dst, n);
            int t = getPoint(i + 1, dst, n);
            edges[s] = new Edge(t, 0, edges[s]);
        }
        return dijkstra(
                getPoint(0, src, n),
                getPoint(K + 1, dst, n),
                n * (K + 2));
    }

    public static void main(String[] args) {
        p787 a = new p787();
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(a.findCheapestPrice(3, edges, 0, 2, 0));
    }

}
