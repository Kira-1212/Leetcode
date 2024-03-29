/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             Node curr = q.poll();
//             if(curr.left != null){
//                 q.add(curr.left);
//                 q.add(curr.right);
//             }
//             for(int i = 1; i<size; i++){
//                 Node temp = q.poll();
//                 curr.next = temp;
//                 if(temp.left != null){
//                     q.add(temp.left);
//                     q.add(temp.right);
//                 }
//                 curr = temp;
//             }
//         }
//         return root;
//     }
// }


class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        Node curr = root;
        while(level.left != null){
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr=curr.next;
            }
            level = level.left;
            curr = level;
        }
        return root;
    }
}