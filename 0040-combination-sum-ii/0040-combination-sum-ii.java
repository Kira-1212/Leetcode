class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
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
        int prev = -1;
        for(int i = index; i<candidates.length; i++){
            if(candidates[i] == prev)
                continue;
            target -= candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i+1 , path);
            target += candidates[i];
            path.remove(path.size()-1);
            prev = candidates[i];
        }
    }
}