class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length-2){
            while(i>0 && i< nums.length-2 && nums[i]==nums[i-1]){
                i++;
            }
            int j=i+1;
            int k= nums.length-1;
            while(j<k){
                int sum =nums[i] +nums[j] +nums[k];
                if(sum==0){
                    List<Integer> smallAns = new ArrayList<>();
                    smallAns.add(nums[i]);
                    smallAns.add(nums[j]);
                    smallAns.add(nums[k]);
                    ans.add(smallAns);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
                else if(sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}
