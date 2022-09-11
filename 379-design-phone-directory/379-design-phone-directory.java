class PhoneDirectory {
    Queue<Integer> q;
    HashSet<Integer> set;
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        q= new LinkedList<>();
        for(int i = 0; i<maxNumbers; i++){
            q.add(i);
            set.add(i);
        }
    }
    
    public int get() {
        if(q.isEmpty()) return -1;
        int num = q.poll();
        set.remove(num);
        return num;
    }
    
    public boolean check(int number) {
        return (set.contains(number));
    }
    
    public void release(int number) {
        if(set.contains(number))return;
        q.add(number);
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */