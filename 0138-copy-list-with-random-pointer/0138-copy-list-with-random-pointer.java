/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node copyHead = clone(head);
        Node copycurr = copyHead;
        
        while(curr != null){
            copycurr.next = clone(curr.next);
            copycurr.random = clone(curr.random);
            curr = curr.next;
            copycurr = copycurr.next;
        }
        return copyHead;
    }
    private Node clone(Node head){
        if(head == null)
            return null;
        if(map.containsKey(head))
            return map.get(head);
        Node cl = new Node(head.val);
        map.put(head, cl);
        return cl;
    }
}