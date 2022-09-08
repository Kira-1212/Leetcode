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
    HashMap<Node,Node> map;
    // public Node copyRandomList(Node head) {
    //     if(head == null )return null;
    //     map = new HashMap<>();
    //     Node copyHead = clone(head);
    //     Node curr = head;
    //     Node copyCurr = copyHead;
    //     while(curr!=null){
    //         copyCurr.next = clone(curr.next);
    //         copyCurr.random = clone(curr.random);
    //         curr =curr.next;
    //         copyCurr = copyCurr.next;
    //     }
    //     return copyHead;
    // }
    public Node copyRandomList(Node head) {
        if(head == null )return null;
        Node curr = head;
        while(curr!=null){
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr= curr.next.next;
        }
        curr = head;
        while(curr!=null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr= curr.next.next;
        }
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;
        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next == null) break;
            copyCurr.next = copyCurr.next.next;
            curr= curr.next;
            copyCurr=copyCurr.next;
            
        }
        return copyHead;
    }
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node))return map.get(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}