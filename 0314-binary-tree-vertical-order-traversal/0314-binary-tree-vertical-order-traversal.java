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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> vert = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        q.add(root);
        vert.add(0);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int v = vert.poll();
            min = Math.min(min, v);
            max = Math.max(max, v);
            if(!map.containsKey(v))
                map.put(v, new ArrayList<>());
            map.get(v).add(curr.val);
            if(curr.left!= null){
                q.add(curr.left);
                vert.add(v-1);
            }
            if(curr.right != null){
                q.add(curr.right);
                vert.add(v+1);
            }

        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = min; i<=max; i++)
        {
            res.add(map.get(i));
        }
        return res;
    }
}