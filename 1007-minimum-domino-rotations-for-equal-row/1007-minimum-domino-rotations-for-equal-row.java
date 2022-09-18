class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length ==0) return 0;
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int target = -1;
        
//         for(int i = 0; i<tops.length; i++){
//             map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
//             map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);
//             if(map.get(tops[i]) >= tops.length){
//                 target = tops[i];
//                 break;
//             }
//             if(map.get(bottoms[i]) >= tops.length){
//                 target = bottoms[i];
//                 break;
//             }
            
//         }
        int target = countRotations(tops, bottoms, tops[0]);
        if(target != -1)
            return target;
        return countRotations(tops, bottoms, bottoms[0]);
    }
    private int countRotations(int[] tops, int[] bottoms, int target){
        int topcount = 0;
        int bottomcount =0;
        for( int i = 0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target)
                return -1;
            if(tops[i] != target)
                topcount++;
            if(bottoms[i] != target)
                bottomcount++;
        }
        return Math.min(topcount, bottomcount);
    }
}