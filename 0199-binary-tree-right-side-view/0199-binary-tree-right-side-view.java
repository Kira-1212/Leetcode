// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         if(root == null)
//             return new ArrayList<>();
//         List<Integer> res = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i<size; i++){
//                 TreeNode curr = q.poll();
//                 if(i == size -1)
//                     res.add(curr.val);
//                 if(curr.left!= null)
//                     q.add(curr.left);
//                 if(curr.right!= null){
//                     q.add(curr.right);
//                 }
//             }
//         }
//         return res;
//     }
// }
class Solution {
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) rightside.add(node.val);

        if (node.right != null) helper(node.right, level + 1);
        if (node.left != null) helper(node.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}

