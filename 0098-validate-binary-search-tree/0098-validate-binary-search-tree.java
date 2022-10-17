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
// class Solution {
//     boolean valid = true;
//     Integer prev;
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)return true;
//         prev = null;
//         return dfs(root);

//     }
    
//     private boolean dfs(TreeNode root){
//         if(root == null)return true;
        
//         if(!dfs(root.left))
//             return false;
//         if(prev != null &&  root.val<=prev ){
//             return false;
//         }
//         prev = root.val;

//         return dfs(root.right);
//     }
// }

class Solution {

    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;

        return dfs(root, null, null);

    }
    
    private boolean dfs(TreeNode root, Integer low, Integer high){
        if(root == null)return true;
        if((low != null && root.val<= low) ||(high != null && root.val>= high)){
            return false;
        }
        return dfs(root.right, root.val, high) && dfs(root.left, low, root.val);
    }
}