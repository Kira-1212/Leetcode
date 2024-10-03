/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        int left = dfs(root.left, p, q) ? 1:0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root ==q)? 1 : 0;
        if(mid + right + left  >=2)
            ans = root;
        return mid+right+left>0;
    }
}