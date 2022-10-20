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
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0)
            return null;
        map = new HashMap<>();
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);

    }

    public TreeNode helper(int[] postorder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = postorder[idx];
        idx--;

        TreeNode root = new TreeNode(rootVal);
        int rootidx = map.get(rootVal);
        root.right = helper(postorder, rootidx + 1, end);
        root.left = helper(postorder, start, rootidx - 1);

        return root;
    }
}