class Solution {
    List<List<Integer>> result;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);
        n = nums.length;
        backtrack(nums_lst, 0);
        return result;
    }
    private void backtrack(List<Integer> nums, int index){
        if(index == n){
            result.add(new ArrayList<>(nums));
            return;
        }
        for(int i= index; i<n; i++){
            Collections.swap(nums, index, i);
            backtrack(nums, index+1);
            Collections.swap(nums, index, i);
        }
        
    }
}