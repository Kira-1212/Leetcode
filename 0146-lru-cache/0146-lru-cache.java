class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map ;
    int capacity;
    
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public LRUCache(int capacity) {
        map  = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        }
        else{
            if(map.size() == capacity){
                Node node = tail.prev;
                removeNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */