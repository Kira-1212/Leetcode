class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        int result = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curr = num;
                int streak = 1;
                while(set.contains(curr+1)){
                    streak++;
                    curr++;
                }
                result = Math.max(streak, result);
            }
        }
        return result;
    }
}