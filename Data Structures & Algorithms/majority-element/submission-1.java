class Solution {
    public int majorityElement(int[] nums) {
         if(nums.length==0){
            return 0;
         }
         int curr=0;
         int currElement=nums[0];
         int max = 0;
         for(int i=0;i<nums.length;i++){
            if(nums[i]==currElement){
                curr++;
            }
            else if(curr==0 && nums[i]!=currElement){
                currElement=nums[i];
                curr++;
            }
            else{
                curr--;
            }
            if(max<curr){
                max=curr;
            }
         }
         return currElement;
    }
}