class LRUCache {
    private class DLLNode{
        private int key;
        private int val;
        DLLNode next ;
        DLLNode prev ;
        public DLLNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, DLLNode> map;
    private  DLLNode head;
    private  DLLNode tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DLLNode(-1,-1);
        this.tail = new DLLNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    private void addNodeToFront(DLLNode newNode){
        DLLNode temp = head.next;
        head.next = newNode;
        newNode.next = temp;
        temp.prev = newNode;
        newNode.prev = head;
        
        
    }

    private void deleteNode(DLLNode node){
        DLLNode delprev = node.prev;
        DLLNode delnext = node.next;
        delprev.next = delnext;
        delnext.prev = delprev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        DLLNode curr = map.get(key);
        map.remove(key);
        deleteNode(curr);
        addNodeToFront(curr);
        map.put(key, head.next);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }

        if(map.size()==capacity){
            DLLNode lastNode = tail.prev;
            int lastkey = lastNode.key;
            map.remove(lastkey);
            deleteNode(lastNode); 
        }

        DLLNode newNode = new DLLNode(key, value);
        addNodeToFront(newNode);
        map.put(key,head.next);
    }
}
