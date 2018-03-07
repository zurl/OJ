package leetcode;

public class p453 {
    public int minMoves(int[] nums) {
        int minn = nums[0], result = 0;
        for(int x : nums) minn = Math.min(minn, x);
        for(int x : nums) result += x - minn;
        return result;
    }

    public static void main(String[] args) {
        p453 a = new p453();
        System.out.println(a.minMoves(new int[]{1, 2, 3}));
    }
}
