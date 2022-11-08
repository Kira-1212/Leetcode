class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        int left = searchLeft(nums, target, low, high);
        if(left != -1){
            int right = searchRight(nums, target, left, high);
            return new int[]{left, right};
        }
        return new int[]{-1,-1};
    }
    
    
    private int searchLeft(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1]<nums[mid])
                    return mid;
                else
                    high = mid -1;
            }
            else if(nums[mid]<target){
                low = mid +1;
            }
            else
                high = mid -1;
        }
        return -1;
    }
    private int searchRight(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1]>nums[mid])
                    return mid;
                else
                    low = mid +1;
            }
            else if(nums[mid]<target){
                low = mid +1;
            }
            else
                high = mid -1;
        }
        return -1;
    }
}