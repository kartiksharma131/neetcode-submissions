class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int count=0;
        int curr=0;
        int next=1;
        while(curr<intervals.length-1 && next<intervals.length){
            if(intervals[curr][1]>intervals[next][0]){
                count++;
                next++;
            }
            else{
                curr=next;
                next++;
            }
        }
        return count;
    }
}
// [1,11],[2,12], [11,22], [1,100];