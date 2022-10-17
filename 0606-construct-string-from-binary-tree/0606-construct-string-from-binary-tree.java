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
    StringBuilder s = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root  == null)return "";
        
        dfs(root);
        return s.toString();
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        
        s.append(root.val);
        if(root.left == null || root.right == null){
            if(root.left == null && root.right == null)
                return;
        }
        s.append("(");
        dfs(root.left);
        s.append(")");
        if(root.right != null){
            s.append("(");
            dfs(root.right);
            s.append(")");
        }
    }
}