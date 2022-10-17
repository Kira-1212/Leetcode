/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        if(root == null)return 0;
        dfs(root, root);
        return count;
    }
    private void dfs(TreeNode root, TreeNode prev){
        if(root == null)return;
        
        if(prev != null & root.val>=prev.val){
            count++;
            prev = root;
            
        }
        
        dfs(root.left, prev);
        dfs(root.right, prev);
    }
}