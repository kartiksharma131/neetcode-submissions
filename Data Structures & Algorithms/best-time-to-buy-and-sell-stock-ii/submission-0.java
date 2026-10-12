class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<prices.length;i++){
            if(!st.isEmpty() && st.peek()>=prices[i]){
                st.pop();
            }
            else if(!st.isEmpty()){
                totalProfit += prices[i] - st.pop();
            }
            st.push(prices[i]);
        }
        return totalProfit;
    }
}