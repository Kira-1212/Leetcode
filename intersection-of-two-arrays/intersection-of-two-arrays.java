class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums1)
            set.add(i);
        Set<Integer> res = new HashSet<>();
        for(int i : nums2)
            if(set.contains(i))
                res.add(i);
        int[] result = new int[res.size()];
        int id = 0;
        for(int i : res)
            result[id++] = i;
        return result;
            
    }
}