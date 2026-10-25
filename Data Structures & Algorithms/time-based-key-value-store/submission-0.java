class TimeMap {
    private class Node{
        String val;
        int timestamp;
        public Node(String val, int timestamp){
            this.val=val;
            this.timestamp=timestamp;
        }
    }
    Map<String, List<Node>> keyValueMap;
    public TimeMap() {
        this.keyValueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyValueMap.containsKey(key)){
            List<Node> newList = new ArrayList<>();
            Node newNode = new Node(value, timestamp);
            newList.add(newNode);
            keyValueMap.put(key, newList);
        }
        else{
            List<Node> keyList = keyValueMap.get(key);
            Node node = new Node(value, timestamp);
            keyList.add(node);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!keyValueMap.containsKey(key)){
            return "";
        }
        List<Node> valueList = keyValueMap.get(key);
        int i=valueList.size()-1;
        while(i>=0){
            if(valueList.get(i).timestamp> timestamp){
                i--;
            }
            else{
                return valueList.get(i).val;
            }
        }
        return "";
    }
}
