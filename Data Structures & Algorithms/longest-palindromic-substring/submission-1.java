class Solution {
    
    public String longestPalindrome(String s) {
        int [] arr = new int[2];
        for(int i=0;i<s.length()-1;i++){
            checkPalindrome(i,i,s,arr);
            checkPalindrome(i,i+1,s, arr);

            
        }
        return s.substring(arr[0], arr[1]+1);
    }

    private void checkPalindrome(int start, int end, String s, int [] arr){
        int longest = arr[1]-arr[0]+1;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            if(end-start+1>longest){
                arr[0]=start;
                arr[1] = end;
                longest = end-start+1;
             }
             start--;
             end++;
        }
    }

}
