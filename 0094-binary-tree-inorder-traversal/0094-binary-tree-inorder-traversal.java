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
//     List<Integer> result = new ArrayList<>();
    
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null) return result;
//         dfs(root);
//         return result;
//     }
    
//     private void dfs(TreeNode root){
//         if(root == null)
//             return;
        
//         dfs(root.left);
//         result.add(root.val);
//         dfs(root.right);
//     }
// }

// class Solution {
//     List<Integer> result = new ArrayList<>();
    
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
            
//         }
//         return result;
//     }
    
    
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode pre = curr.left;
                while(pre.right != curr && pre.right != null){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}