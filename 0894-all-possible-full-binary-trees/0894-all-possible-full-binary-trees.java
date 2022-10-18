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
    Map<Integer,List<TreeNode>> dp = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!dp.containsKey(n)){
            List<TreeNode> result = new ArrayList<>();
            if(n == 1)
                result.add(new TreeNode(0));
            else if(n % 2 ==1){
                for(int l = 0; l<n; l++){
                    int r = n-1-l;
                    for( TreeNode left : allPossibleFBT(l)){
                        for(TreeNode right : allPossibleFBT(r)){
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            result.add(root);
                        }
                    }
                }
            }
            dp.put(n, result);
        }
        return dp.get(n);
    }
}