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
    int buckets;
    Node[] hash;
    public MyHashMap() {
        buckets = 10000;
        hash = new Node[buckets];
    }
    
    private Node find(Node root, int key)
    {
        Node prev = root;
        Node curr = prev.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
        
        
    }
    
    private int getHash(int key){
        return key%buckets;
    }
    public void put(int key, int value) {
        int hashKey = getHash(key);
        if(hash[hashKey] == null){
            hash[hashKey] = new Node(-1, -1);
        }
        Node prev = find(hash[hashKey], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }
    
    public int get(int key) {
        int hashKey = getHash(key);
        if(hash[hashKey] == null)
            return -1;
        Node prev = find(hash[hashKey], key);
        if(prev.next == null)
            return -1;
        else
            return prev.next.value;
    }
    
    public void remove(int key) {
        int hashKey = getHash(key);
        if(hash[hashKey] != null){
            Node prev = find(hash[hashKey], key);
            if(prev.next != null)
                prev.next = prev.next.next;
            else
                return;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */