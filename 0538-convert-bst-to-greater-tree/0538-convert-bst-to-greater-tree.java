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
    int currSum;
    public TreeNode convertBST(TreeNode root) {
        TreeNode curr = root;
        dfs(curr);
        return root;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.right);
        int temp = root.val;
        root.val += currSum;
        currSum += temp;
        dfs(root.left);
    }
}