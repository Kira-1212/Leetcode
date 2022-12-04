class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String s="";
        for(int i=0;i<nums.length;i++){
            char a=nums[i].charAt(i);
            if(a=='0'){
                a='1';
            }
            else{
                a='0';
            }
            s=s+a;
        }
        return s;
    }
}