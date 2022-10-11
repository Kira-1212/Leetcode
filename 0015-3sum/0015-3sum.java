class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            if(i == 0 || nums[i-1] != nums[i] )
                twoSum(nums, i);
        }
        return result;
    }
    
    private void twoSum(int[] nums, int i){
        List<Integer> res = new ArrayList<>();
        int l = i +1;
        int r = nums.length -1;
        while(l<r){
            
            int sum = nums[i] + nums[l] + nums[r];
            if(sum<0)
                l++;
            else if(sum>0)
                r--;
            else{
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                while(l<r && nums[l] == nums[l-1])
                    ++l;
            }
            
        }
    }
}