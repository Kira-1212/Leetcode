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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), new HashMap<>(), res);
        return res;
    }
    
    private int traverse(TreeNode root, HashMap<String, Integer> tripletMap, HashMap<Integer, Integer> map, List<TreeNode> res){
        if(root == null)
            return 0;
        String triplet = traverse(root.left, tripletMap, map, res) + "," + root.val + "," + traverse(root.right, tripletMap, map, res);
        if(!tripletMap.containsKey(triplet)){
            tripletMap.put(triplet, tripletMap.size()+1);
        }
        int id = tripletMap.get(triplet);
        map.put(id, map.getOrDefault(id, 0)+1);
        if(map.get(id) == 2){
            res.add(root);
        }
        return id;
    }
}