class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i));
            sb.append("@@");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<str.length()){
            if(str.charAt(j)=='@' && str.charAt(j+1)=='@'){
                ans.add(str.substring(i,j));
                j+=2;
                i=j;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}
