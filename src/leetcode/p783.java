package leetcode;

public class p783 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode l, TreeNode r) { val = x;left = l;right = r; }
    }

    Integer lastValue;
    int result;

    void dfs(TreeNode x ){
        if( x.left != null) dfs(x.left );
        if( lastValue != null && x.val - lastValue < result) result = x.val - lastValue;
        lastValue = x.val;
        if( x.right != null ) dfs(x.right);
    }

    public int minDiffInBST(TreeNode root) {
        result = Integer.MAX_VALUE;
        lastValue = null;
        dfs(root);
        return result;
    }

    public static void main(String[] args) {
        p783 a = new p783();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6)
        );
        System.out.println(a.minDiffInBST(root));
    }
}
