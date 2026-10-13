class Solution {
    private int robHouseHelper(int start, int end, int [] nums){
        if(end==start+1){
            return Math.max(nums[start], nums[start+1]);
        }
        int first =nums[start];
        int second = Math.max(nums[start], nums[start+1]);
        int maxLoot = 0;
        for(int i=start+2;i<end;i++){
            maxLoot = Math.max(second, first + nums[i]);
            first = second;
            second=maxLoot;
        }
        return second;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }

        int answer1 = robHouseHelper(0,n-1,nums);
        int answer2 = robHouseHelper(1,n,nums);
        return Math.max(answer1, answer2);
    }
}

