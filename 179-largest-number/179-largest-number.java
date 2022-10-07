class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new LargerNumberComparator());
        
        if(strs[0].equals("0"))
            return "0";
        
        String largestNumberStr = new String();
        for (String numAsStr : strs) {
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;
    }
}