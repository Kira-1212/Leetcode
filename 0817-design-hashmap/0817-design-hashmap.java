class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
        
    }

    public int getHash(int key){
        return Integer.hashCode(key) % buckets;
    }

    public Node find(Node node, int key){
        Node prev = node;
        Node curr = prev.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }


    
    public void put(int key, int value) {
        int hash = getHash(key);
        if(nodes[hash] == null){
            nodes[hash] = new Node(-1,-1);
        } 
        Node prev = find(nodes[hash], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }
    
    public int get(int key) {
        int id = getHash(key);
        if(nodes[id]  == null)
            return -1;
        Node prev = find(nodes[id], key);
        if(prev.next == null)
            return -1;
        else
            return prev.next.value;
    }
    
    public void remove(int key) {
        int id = getHash(key);
        if(nodes[id] == null)
            return;
        Node prev = find(nodes[id], key);
        if(prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */