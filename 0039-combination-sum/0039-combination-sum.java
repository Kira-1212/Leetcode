class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        backtrack(candidates, target, 0, new ArrayList());
        return result;
    }
    private void backtrack(int[] candidates, int target, int index, List<Integer> path){
        if(target <= 0){
            if(target== 0){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = index; i<candidates.length; i++){
            target -= candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i, path);
            target += candidates[i];
            path.remove(path.size()-1);
        }
    }
}