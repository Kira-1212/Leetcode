class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int max= 0;
        int maxEl = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>max){
                maxEl = num;
                max = map.get(num);
            }
            
        }
        return maxEl;
    }
    
}