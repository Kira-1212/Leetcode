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
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if(root == null)return new ArrayList<>();
//         List<List<Integer>> result = new ArrayList<>();
        
//         Queue<TreeNode> q = new LinkedList<>();
        
//         q.add(root);
        
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> r = new ArrayList<>();
//             for( int i = 0; i<size; i++){
                
//                 TreeNode curr = q.poll();
//                 r.add(curr.val);
//                 if(curr.left!=null)
//                     q.add(curr.left);
//                 if(curr.right!=null)
//                     q.add(curr.right);
//             }
//             result.add(r);
            
//         }
//         return result;
//     }
// }


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        dfs(root, 0);
        
        
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null)return;
        
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level +1);
    }
}