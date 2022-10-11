class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            twoSum(nums, i);
        }
        return new ArrayList(result);
    }
    
    private void twoSum(int[] nums, int i){
        List<Integer> res = new ArrayList<>();
       
        int target = -nums[i];
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int j = i+1; j<nums.length; j++){
            int comp = target - nums[j];
            if(map.containsKey(comp) && map.get(comp) == i){
                List<Integer> triplet = Arrays.asList(nums[i], nums[j], comp);
                Collections.sort(triplet);
                result.add(triplet);
            }
            else{
                map.put(nums[j], i);
            }
        }
        
    }
}