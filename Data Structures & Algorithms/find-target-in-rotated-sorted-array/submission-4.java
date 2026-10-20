class Solution {

    private int getPivot(int [] nums){
        int start =0;
        int end= nums.length-1;
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
        return start;
    }

    private int binarySearch(int start, int end, int [] nums, int target){
        int mid = start+ (end-start)/2;
        while(start<=end){
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end--;
            }
            else{
                start++;
            }
            mid = start+ (end-start)/2;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivotIndex = getPivot(nums);
        if(nums[0]<=nums[nums.length-1]){
            return binarySearch(0,nums.length-1,nums, target);
        }
        if(target>=nums[0]){
            return binarySearch(0,pivotIndex-1,nums, target);

        }
        else{
            return binarySearch(pivotIndex, nums.length-1, nums, target);
        }
    }
}
