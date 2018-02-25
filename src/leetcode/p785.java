package leetcode;

public class p785 {

    int[][] g;
    int[] flag;

    public boolean mark(int p, int k){
        if( flag[p] != 0){
            return flag[p] == k;
        }
        flag[p] = k;
        int[] edges = g[p];
        for(int x: edges){
            if( !mark(x, k == 1? 2: 1) ) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        g = graph;
        int n = graph.length;
        flag = new int[n];
        for(int i = 0; i < n; i ++){
            if( flag[i] == 0 ){
                if(!mark(i, 1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
