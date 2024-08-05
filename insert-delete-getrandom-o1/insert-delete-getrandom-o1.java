class RandomizedSet {
    List<Integer> li;
    Random rand;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        li = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, li.size());
            li.add(li.size(), val);
            return true;
        }
        return false;

    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int temp = li.get(li.size()-1);
            li.set(index, temp);

            map.put(temp, index);
            map.remove(val, index);
            li.remove(li.size()-1);
            return true;
        }
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