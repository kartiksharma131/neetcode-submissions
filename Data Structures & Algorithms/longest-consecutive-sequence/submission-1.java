class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longest=0;
        for(int val : set ){
            if(set.contains(val-1)){
                continue;
            }
            else{
                int currCount=1;
                while(set.contains(val+1)){
                    currCount++;
                    val++;
                }
                longest = Math.max(longest, currCount);
            }
        }
        return longest;
    }
}
