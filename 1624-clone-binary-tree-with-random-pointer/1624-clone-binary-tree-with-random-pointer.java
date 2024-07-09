/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node, NodeCopy> pairs = new HashMap<>();

    private NodeCopy deepCopy(Node root){
        if(root == null)
            return null;
        NodeCopy newRoot = new NodeCopy(root.val);
        newRoot.left = deepCopy(root.left);
        newRoot.right = deepCopy(root.right);

        pairs.put(root, newRoot);
        return newRoot;
    }

    private void mapRandom(Node root){
        if(root == null)
            return;
        
        NodeCopy newNode = pairs.get(root);
        Node rootRandom = root.random;
        NodeCopy newNodeRandom = pairs.get(rootRandom);
        newNode.random = newNodeRandom;
        mapRandom(root.left);
        mapRandom(root.right);
    }
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null)
            return null;
        NodeCopy newRoot = deepCopy(root);
        mapRandom(root);
        return newRoot;
    }
}