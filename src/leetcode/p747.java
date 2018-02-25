package leetcode;

import java.util.Arrays;

public class p747 {
    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        int maxn = Integer.MIN_VALUE, maxi = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > maxn){ maxn = nums[i]; maxi = i; }
        }
        Arrays.sort(nums);
        return nums[nums.length - 1] >= nums[nums.length - 2] * 2 ? maxi : -1;
    }
}
