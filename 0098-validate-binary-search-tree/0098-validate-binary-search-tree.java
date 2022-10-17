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
    boolean valid = true;
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        prev = null;
        return dfs(root);

    }
    
    private boolean dfs(TreeNode root){
        if(root == null)return true;
        
        if(!dfs(root.left))
            return false;
        if(prev != null &&  root.val<=prev ){
            return false;
        }
        prev = root.val;

        return dfs(root.right);
    }
}