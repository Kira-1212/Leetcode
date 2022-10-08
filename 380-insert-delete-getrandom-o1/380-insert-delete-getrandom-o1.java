class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> li;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        li = new LinkedList<>();
        
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, li.size());
            li.add(li.size(), val);
            return true;
        }
        else
            return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int temp = li.get(li.size()-1);
            int i = map.get(val);
            li.set(i, temp);
            map.put(temp, i);
            
            map.remove(val ,i);
            li.remove(li.size()-1);


            return true;
        }
        else
            return false;
    }
    
    public int getRandom() {
        int i = rand.nextInt(li.size());
        return li.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */