class Solution {
    public int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;
        int totalWater=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]<leftMax){
                    totalWater+= leftMax - height[left];
                    
                }
                else{
                    leftMax = height[left];
                }
                left++;
            }
            else{
                if(height[right]<rightMax){
                    totalWater += rightMax - height[right];
                }
                else{
                    rightMax = height[right];
                }
                right--;
            }

        }
        return totalWater;
    }
}
