class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(n, k, new ArrayList());
        return result;
    }
    private void backtrack(int n, int k, List<Integer> path){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        if(n == 0)
            return;
        
        for(int i = n; i>0; i--){
            path.add(i);
            backtrack(i-1, k, path);
            path.remove(path.size()-1);
        }
    }
    
}