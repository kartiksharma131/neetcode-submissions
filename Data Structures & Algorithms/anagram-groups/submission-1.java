class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char [] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if(!map.containsKey(sortedStr)){
                List<String> smallList = new ArrayList<>();
                smallList.add(str);
                map.put(sortedStr, smallList);
            }
            else{
                List<String> anagramList = map.get(sortedStr);
                anagramList.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
