class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(total < 0) total = 0;

            total += nums[i];
            if(total > result) result = total;
        }

        return result;
    }
}