class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxLength =0;
        int start=0;
        int end = 0;
        while(end<s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(end)));
            
            int currLen = end-start +1;
            if(currLen-maxFreq>k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }

            currLen = end-start+1;
            maxLength = Math.max(maxLength, currLen);
            end++;
        } 
        return maxLength;
    }
}
