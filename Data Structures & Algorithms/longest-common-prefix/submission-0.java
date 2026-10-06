class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int i=0;
        StringBuilder ans = new StringBuilder("");
        while(i<str1.length() &&i<str2.length()){
            if(str1.charAt(i)==str2.charAt(i)){
                ans.append(str1.charAt(i));
                i++;
            }
            else{
                break;
            }
        }
        return ans.toString();
    }
}