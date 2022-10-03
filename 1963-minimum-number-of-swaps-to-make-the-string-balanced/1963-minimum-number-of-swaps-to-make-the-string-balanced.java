class Solution {
    public int minSwaps(String s) {
        int o = 0;
       
        int swap = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(o<0){
                swap++;
                o=0;
            }
            if(ch == '['){
                o++;
            }
            else if(ch == ']' )
                o--;
            
        }
        return (int)(Math.ceil(swap/2.0));
    }
}