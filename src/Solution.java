class Solution {
    public int trap(int[] height) {
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            if(height[i] > max) max = height[i];
        }
        int volume = 0;
        int leftPointer;
        int rightPointer;


        for (int m = 0; m < max; m++) {
            leftPointer = 0;
            while(height[leftPointer] == 0) leftPointer++;
            for (int i = leftPointer; i < height.length; ) {
                if(height[i] == 0){
                    leftPointer = i - 1;
                    rightPointer = i + 1;
                    while(rightPointer <= height.length - 1 && height[rightPointer] == 0) rightPointer++;

                    if(rightPointer <= height.length - 1) {
                        int buff = rightPointer - leftPointer - 1;
                        volume += buff;
                    }
                    i = rightPointer;
                }
                else{
                    i++;
                }

            }

            for (int i = 0; i < height.length; i++) {
                if(height[i] != 0){
                    height[i]--;
                }
            }
        }

        return volume;
    }


}