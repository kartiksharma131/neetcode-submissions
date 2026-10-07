class Solution {
    int getPivotIndex(int [] nums){
        int start=0;
        int end = nums.length-1;
        int mid = start +(end-start)/2;
        while(start<end){
            
            if(nums[mid]>=nums[0]){
                start=mid+1;
            }
            else{
                end=mid;
            }
            mid = start +(end-start)/2;
        }
        return mid;
    }
    public int findMin(int[] nums) {
        int pivot = getPivotIndex(nums);
        if(nums[0]<=nums[nums.length-1]){
            return nums[0];
        }
        return nums[pivot];
    }
}
