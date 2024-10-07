class Solution {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] s = str.toCharArray();

        int[] max = new int[s.length];
        int i = s.length-1;
        max[i] = i;
        for(int k = s.length-2; k>=0; k--){
            if(s[i] < s[k])
                i = k;
            max[k] = i;
        }

        for(int j = 0; j<s.length; j++){
            if(s[j] < s[max[j]]){
                char temp = s[j];
                s[j] = s[max[j]];
                s[max[j]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(s));
    }
}