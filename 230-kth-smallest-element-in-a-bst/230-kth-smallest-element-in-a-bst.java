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
    List<Integer> li;
    public int kthSmallest(TreeNode root, int k) {
        li = new ArrayList<>();
        dfs(root);
        for(int i = 0; i<li.size(); i++)
            if( i+1 ==k)
                return li.get(i);
        return 0;
    }
    private  void dfs(TreeNode root){
        if (root == null)return;
        dfs(root.left);
        li.add(root.val);
        dfs(root.right);
    }
}