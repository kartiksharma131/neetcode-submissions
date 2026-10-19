class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int i=0;
        int curr=1;
        int count=0;
        while(i<intervals.length-1 && curr<intervals.length){
            if(intervals[i][1]>intervals[curr][0]){
                count++;
                curr++;
            }
            else{
                i =curr;
                curr++;
            }
        }
        return count;
    }
}
// [1,11],[2,12], [11,22], [1,100];