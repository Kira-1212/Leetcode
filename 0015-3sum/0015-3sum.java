// class Solution {
//     List<List<Integer>> res ;
//     public List<List<Integer>> threeSum(int[] nums) {
//         res = new ArrayList<>();

//         if(nums == null || nums.length == 0)
//             return res;
//         Arrays.sort(nums);

//         for(int i = 0; i<nums.length; i++){
//             if(i == 0 || nums[i-1] != nums[i])
//                 twosum(nums, i);
//         }
//         return res;
//     }

//     private void twosum(int[] nums, int i){
//         int l = i+1, r = nums.length -1;
//         while(l<r){
//             int sum = nums[i] + nums[l] + nums[r];

//             if(sum<0)
//                 l++;
//             else if(sum> 0)
//                 r--;
//             else{
//                 res.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                 r--;
//                 l++;
//                 while(l<r && nums[l-1] == nums[l])
//                     l++;
//             }
//         }
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) if (
            i == 0 || nums[i - 1] != nums[i]
        ) {
            twoSum(nums, i, res);
        }
        return res;
    }

    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) ++j;
            }
            seen.add(nums[j]);
        }
    }
}