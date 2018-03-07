package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class p508 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> hm;

    int dfs(TreeNode x){
        int v = x.val;
        if(x.left != null) v += dfs(x.left);
        if(x.right != null) v += dfs(x.right);
        Integer i = hm.get(v);
        if( i == null ) hm.put(v, 1);
        else hm.put(v, i + 1);
        return v;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if( root == null) return new int[]{};
        hm = new HashMap<>();
        dfs(root);
        ArrayList<Integer> a = new ArrayList<>();
        int maxn = 0;
        for(Integer i: hm.keySet()){
            Integer v = hm.get(i);
            if(v > maxn){
                maxn = v;
                a = new ArrayList<>();
            }
            if(v == maxn){
                a.add(i);
            }
        }
        int[] result = new int[a.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = a.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        p508 a = new p508();
        System.out.println(a.findFrequentTreeSum(null));
    }
}
