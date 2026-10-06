class Solution {
    public int maxArea(int[] heights) {
        int low=0;
        int high = heights.length-1;
        int maxWater=0;
        while(low<high){
            int currWater = Math.min(heights[low], heights[high])*(high-low);
            maxWater = Math.max(maxWater, currWater);
            if(heights[low]<heights[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return maxWater;
    }
}

