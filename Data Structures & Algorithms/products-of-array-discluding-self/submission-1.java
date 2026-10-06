class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] prefixProdArr = new int[n];
        int [] suffixProdArr = new int[n];
        int prefixProd=1;
        int suffixProd=1;
        for(int i=0;i<n;i++){
            prefixProdArr[i] = prefixProd;
            prefixProd *=nums[i];
        }
        int [] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            suffixProdArr[i] = suffixProd;
            suffixProd *= nums[i];
            ans[i] =  prefixProdArr[i]*suffixProdArr[i];
        }

        return ans;
    }
}  

// prefixProdArr = [1,1,2,8]
// sufficProdArr = [48,24,6,1]