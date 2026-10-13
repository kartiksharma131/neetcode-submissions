class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length];
        
        int first = cost[0];
        int second = cost[1];
        if(cost.length==1){
            return first;
        }
        if(cost.length==2){
            return Math.min(first,second);
        }
        int costToLast =0;
        for(int i=2;i<cost.length;i++){
            costToLast = cost[i] + Math.min(first,second);
            first = second;
            second = costToLast;
        }
        return Math.min(first,second);
    }
}
