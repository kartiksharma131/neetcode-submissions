class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }

        int [] dp = new int[nums.length+1];
        int firstLoot = nums[0];
        int secondLoot = Math.max(nums[0],nums[1]);
        if(n==2){
            return secondLoot;
        }
        int maxLoot =0;
        for(int i=2;i<nums.length;i++){
            maxLoot = Math.max(secondLoot, firstLoot + nums[i]);
            firstLoot = secondLoot;
            secondLoot = maxLoot;
        }
        return maxLoot;
    }
}
