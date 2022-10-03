class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for(int i = 0; i<rectangles.length; i++){
            double ratio = (double)rectangles[i][0]/(double)rectangles[i][1];
            result+= map.getOrDefault(ratio, 0);
            map.put(ratio, map.getOrDefault(ratio,0)+1);
        }
        return result;
    }
}