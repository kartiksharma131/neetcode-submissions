class Solution {
    private boolean checkPaildrome(int start, int end, String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i= 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return checkPaildrome(i,j-1,s) || checkPaildrome(i+1,j,s);
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}