class Solution {
    public int[] singleNumber(int[] nums) {
        int xor =0;
        for( int num : nums){
            xor ^= num;
            
        }
        int temp = xor & -xor;
        int xor2 = 0;
        for(int num : nums){
            if((temp & num )!= 0){
                xor2 = xor2 ^ num;
            }
        }
        return new int[]{xor2, xor ^ xor2};
        
    }
}