class Solution {
    public int[] findBuildings(int[] heights) {
        int max = heights[heights.length-1];
        List<Integer> res = new ArrayList();
        res.add(heights.length-1);
        for(int i = heights.length-2; i>=0; i--){
            if(max<heights[i]){
                res.add(i);
                max = heights[i];
            }
        }
        int [] ans = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(res.size()-1-i);
        }
        return ans;
    }
}