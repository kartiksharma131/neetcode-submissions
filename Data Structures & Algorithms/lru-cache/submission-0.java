class LRUCache {
    private class Node{
        private int key;
        private int value;
        Node next=null;
        Node prev=null;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private final int capacity;
    public LRUCache(int capacity) {
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    private void addNode(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        temp.prev = node;
        node.next = temp;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            int res = curr.value;
            map.remove(key);
            deleteNode(curr);
            addNode(curr);
            map.put(key, head.next);
            
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
            Node curr = map.get(key);
            deleteNode(curr);
            map.remove(key);
       }
       if(map.size()==capacity){
            Node lastNode = tail.prev;
            int delkey = lastNode.key;
            deleteNode(lastNode);
            map.remove(delkey);

       }

       Node newNode = new Node(key,value);
       addNode(newNode);
       map.put(key,head.next);
    }
}
