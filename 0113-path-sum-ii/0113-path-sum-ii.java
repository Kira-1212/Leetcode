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
    List<List<Integer>> result;
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        sum = targetSum;
        dfs(root, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> path, int currsum ){
        if(root == null)
            return;
        currsum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currsum == sum ){
                result.add(new ArrayList<>(path));

            }
        }
        dfs(root.right, path, currsum);
        dfs(root.left, path, currsum);
        path.remove(path.size()-1);
    }
}