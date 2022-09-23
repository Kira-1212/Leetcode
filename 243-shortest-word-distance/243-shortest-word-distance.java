class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i = -1;
        int j = -1;
        int min = Integer.MAX_VALUE;
        for(int k = 0; k<wordsDict.length; k++){
            if(wordsDict[k].equals(word1)){
                i =k;   
            }
            if(wordsDict[k].equals(word2)){
                j = k;
            }
            if(i != -1 && j !=-1){
                min = Math.min(min, Math.abs(i -j));
            }
        }
        return min;
    }
}