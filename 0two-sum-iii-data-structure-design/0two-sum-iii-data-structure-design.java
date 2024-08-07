class TwoSum {
    HashMap<Integer, Integer> map ;
    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
    }
    
    public boolean find(int value) {
        for(int key : map.keySet()){
            int comp = value - key;
            if(comp == key){
                if(map.get(key) >1)
                    return true;
            }
            else{
                if(map.containsKey(comp))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */