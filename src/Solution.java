import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;

        Map<Integer, Integer> buffer = new HashMap<>();
        buffer.put(0, -1);
        int prefSum = 0;
        int remains = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && i != nums.length - 1 && nums[i+1] == 0) return true;
            prefSum += nums[i];
            remains = prefSum % k;
            if(buffer.containsKey(remains) && i - buffer.get(remains) >= 2) return true;
            else if(!buffer.containsKey(remains)) buffer.put(remains, i);
        }

        return false;
    }
}

