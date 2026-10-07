class Solution {
    private class Pair{
        private int temp;
        private int idx;
        public Pair(int temp, int idx){
            this.temp = temp;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int [] ans = new int[temperatures.length];
        for(int i= temperatures.length-1; i>=0 ; i--){
            if(st.isEmpty()){
                ans[i]=0;
                
            }
            else{
                while(!st.isEmpty() && st.peek().temp<= temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                        ans[i]=0;
                    }
                    else{
                        ans[i] = st.peek().idx - i;
                    }
            }
            st.push(new Pair(temperatures[i],i));
        }
        return ans;
    }
}

