public class Solution2 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int volume = 0;

        int leftMax = height[left];
        int rightMax = height[right];
// [4,2,0,3,2,5]
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(height[left], leftMax);
                volume += leftMax - height[left];
            }
            else{
                right--;
                rightMax = Math.max(height[right], rightMax);
                volume += rightMax - height[right];
            }
        }

        return volume;
    }
}
