class LRUCache {
    private class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private final Node head= new Node(-1,-1);
    private final Node tail = new Node(-1,-1);
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node delnode){
        Node prevNode = delnode.prev;
        Node nextNode = delnode.next;
        prevNode.next= nextNode;
        nextNode.prev = prevNode;
    }

    private void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        temp.prev = newNode;
        head.next = newNode;
        newNode.prev = head;

    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node keyNode = map.get(key);
        map.remove(key);
        deleteNode(keyNode);
        addNode(keyNode);
        map.put(key, head.next);
        return keyNode.val;
    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
        }
        if(map.size()>=capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node newNode = new Node(key,val);
        addNode(newNode);
        map.put(key, head.next);
    }
}
