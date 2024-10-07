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
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node curr = head;
        Node copyHead = clone(head);
        Node copyCurr = copyHead;

        while(curr != null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    private Node clone(Node node){
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        Node cl = new Node(node.val);
        map.put(node, cl);
        return cl;
    }
}