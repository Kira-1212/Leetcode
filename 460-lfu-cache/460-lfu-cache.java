class LFUCache {
    class Node{
        int key, val, cnt;
        Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.cnt = 1;
        }
    }
    class DLL{
        Node head, tail;
        int size;
        public DLL(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;

        }
        public void addToHead(Node node){
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
            size++;
        }
        public void removeNode(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
            
        }
        public Node removeLast(){
            Node tailPrev = tail.prev;
            removeNode(tailPrev);
            return tailPrev;
        }
    }
    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqmap;
    int capacity,min;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqmap = new HashMap<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0)return;
        if(map.containsKey(key)){
            Node node = map.get(key);
            update(node);
            node.val = value;
            return;
        }
        if(capacity == map.size()){
            DLL oldList = freqmap.get(min);
            Node node = oldList.removeLast();
            map.remove(node.key);
        }
        Node newNode = new Node(key, value);
        min = 1;
        DLL newList = freqmap.getOrDefault(min, new DLL());
        newList.addToHead(newNode);
        freqmap.put(min, newList);
        map.put(key, newNode);
    }
    public void update(Node node){
        DLL oldList = freqmap.get(node.cnt);
        if(oldList !=null){
            oldList.removeNode(node);
        }
        if(oldList.size==0 && min == node.cnt){
            min++;
        }
        node.cnt++;
        DLL newList = freqmap.getOrDefault(node.cnt, new DLL());
        newList.addToHead(node);
        freqmap.put(node.cnt, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */