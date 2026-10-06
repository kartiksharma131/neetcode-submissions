class Solution {
    public void leftShift(int [] nums, int start){
        while(start<nums.length-1){
            nums[start]=nums[start+1];
            start++;
        }
    }
    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int i=0;
        int shift=0;
        
        while(i<nums.length-1){
            if(nums[i]==val){
                shift++;
                leftShift(nums,i);
                nums[nums.length-1]=Integer.MAX_VALUE;
            }
            else{
                i++;
            }
        }
        if(nums[i]==val){
            return nums.length-1;
        }
        else{
            return nums.length-shift;
        }
    }
}