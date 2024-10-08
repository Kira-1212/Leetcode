class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int lo = 0;
        int hi = 0;
        List<int[]> res = new ArrayList<>();
        int i = 0, j =0;
        while(i<firstList.length && j<secondList.length){
            lo = Math.max(firstList[i][0], secondList[j][0]);
            hi = Math.min(firstList[i][1], secondList[j][1]);

            if(lo<=hi){
                res.add(new int[]{lo,hi});
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}