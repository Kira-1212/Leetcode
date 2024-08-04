class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(char c : jewels.toCharArray()){
            set.add(c-'a');
        }
        for(char c: stones.toCharArray()){
            if(set.contains(c-'a'))
                res++;
        }
        return res;
    }
}