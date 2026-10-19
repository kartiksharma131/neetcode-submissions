class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int []> merged = new ArrayList<>();
        
        int [] newInterval = intervals[0];
        merged.add(newInterval);
        
        for(int [] interval : intervals){
            if(newInterval[1]>=interval[0]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            else{
                newInterval = interval;
                merged.add(newInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }
}
