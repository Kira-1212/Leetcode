class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int buckets;
    Node[] map;
    public MyHashMap() {
         buckets = 10000;
        map = new Node[buckets];    
    }
    
    public int getHash(int key){
        return (key % buckets);
    }
    public Node find(Node node, int key){

        Node prev = node;
        Node curr = prev.next;
        while(curr != null && curr.key != key){
            curr = curr.next;
            prev = prev.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int hash = getHash(key);
        if(map[hash] == null)
            map[hash] = new Node(-1, -1);
        Node prev = find(map[hash], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.val =  value;
    }
    
    public int get(int key) {
        int hash = getHash(key);
        if(map[hash] == null)
            return -1;
        Node prev = find(map[hash], key);
        if(prev.next == null )
            return -1;
        else
            return prev.next.val;
    }
    
    public void remove(int key) {
        int hashKey = getHash(key);
        if(map[hashKey] != null){
            Node prev = find(map[hashKey], key);
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