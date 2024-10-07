class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head, tail;
    HashMap<Integer, Node> map ;


    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            removeNode(curr);
            addToHead(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value;
            removeNode(curr);
            addToHead(curr);
        }
        else{
            if(map.size() == capacity){
                Node curr = tail.prev;
                removeNode(curr);
                map.remove(curr.key);
            }
            Node curr = new Node(key, value);
            addToHead(curr);
            map.put(key, curr);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */