class MyCircularQueue {
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val, ListNode p, ListNode n){
            this.val = val;
            prev = p;
            next = n;
        }
    }
    int size;
    ListNode head,tail;
    public MyCircularQueue(int k) {
        size = k;
         head = new ListNode(0, null, null);
         tail = new ListNode(0, head, null );
        head.next = tail;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        ListNode v = new ListNode(value, tail.prev, tail);
        tail.prev.next =v;
        tail.prev =v;
        size--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head.next = head.next.next;
        head.next.prev = head;
        size++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return head.next.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return head.next == tail;
    }
    
    public boolean isFull() {
        return size == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */