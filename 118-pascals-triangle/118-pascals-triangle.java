class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i =1; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j =1 ;j<i; j++){
                row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}