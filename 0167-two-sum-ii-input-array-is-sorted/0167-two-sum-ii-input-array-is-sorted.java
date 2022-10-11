class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l =0;
        int r = numbers.length-1;
        while(l<r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1, r+1};
            }
            if(numbers[l] + numbers[r] > target)
                r--;
            else
                l++;
        }
        return result;
    }
}