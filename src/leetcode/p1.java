package leetcode;
import java.util.Arrays;
import java.util.Comparator;

public class p1 {

    public int[] twoSumNaive(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Integer[] idx = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) idx[i] = i;
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(nums[o1], nums[o2]);
            }
        });
        int l = 0, r = nums.length - 1;
        while( nums[idx[l]] + nums[idx[r]] != target){
            if(nums[idx[l]] + nums[idx[r]] > target){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[]{
            Math.min(idx[l], idx[r]),
            Math.max(idx[l], idx[r])
        };
    }
}
