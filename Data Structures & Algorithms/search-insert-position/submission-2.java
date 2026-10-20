class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0]){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        int low=0;
        int high = nums.length-1;
        int mid = low +(high-low)/2;
        int ans =-1;
        while(low<=high){
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                ans = mid+1;
                low=mid+1;
            }
            else{
                high = mid-1;
            }
            mid = low +(high-low)/2;
        }
        return ans;
    }
}