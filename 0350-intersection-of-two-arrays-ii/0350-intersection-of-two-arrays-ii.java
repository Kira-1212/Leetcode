class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)return new int[]{};
        
        int m = nums1.length;
        int n = nums2.length;
        if(n<m)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        List<Integer> res = new ArrayList<>();
        for( int i = 0; i<m; i++){
            int loc = binarySearch(nums2, index, nums1[i]);
            if(loc < nums2.length && nums2[loc] == nums1[i]){
                res.add(nums2[loc]);
                index = loc +1;
            }
        }
        int[] ans = new int[res.size()];
        for(int j = 0; j<res.size(); j++){
            ans[j] = res.get(j);
        }
        return ans;
    }
    
    private int binarySearch(int[] nums, int low, int target){
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid +1;
            }
            else
                high = mid -1;
        }
        return low;
        
    }
}