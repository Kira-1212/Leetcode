class Solution {
    public int maxPotholes(String road, int budget) {
        List<Integer> pots = new ArrayList<>();
        int c = 0;

        for(char ch : road.toCharArray()){
            if(ch == 'x'){
                c++;
            }
            else{
                if(c>0){
                    pots.add(c);
                }
                c = 0;
            }
        }
        if(c>0)
            pots.add(c);
        Collections.sort(pots, Collections.reverseOrder());
        int count = 0;
        for(int p : pots){
            if(p+1>= budget){
                count+=budget-1;
                return count;
            }
            budget -= (p+1);
            count += p;
        }
        return count;
    }
}