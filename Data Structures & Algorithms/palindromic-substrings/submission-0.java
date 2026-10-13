class Solution {
    public int countSubstrings(String s) {
        int [] count= new int[1];
        for(int i=0;i<s.length()-1;i++){
            checkPalindrome(i,i,s,count);
            checkPalindrome(i,i+1,s,count);

        }
        return count[0]+1;
    }

    private void checkPalindrome(int start, int end, String s, int [] count){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            count[0]++;
            start--;
            end++;
        }
    }
}
