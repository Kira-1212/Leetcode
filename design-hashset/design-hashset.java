class MyHashSet {
    boolean[][] myset;
    int buckets;
    int bucketitems;
    public MyHashSet() {
        buckets = 1000;
        bucketitems = 1000;
        myset = new boolean[buckets][];
    }
    
    private int getBucket(int key){
        return key%buckets;
    }
    private int getBucketSize(int key){
        return key/buckets;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketSize = getBucketSize(key);
        if(myset[bucket] == null){
            if(bucket == 0)
                myset[bucket] = new boolean[bucketitems+1];
            else
                myset[bucket] = new boolean[bucketitems];
        }
        myset[bucket][bucketSize] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketSize = getBucketSize(key);
        if(myset[bucket] != null)
            myset[bucket][bucketSize] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketSize = getBucketSize(key);
        if(myset[bucket] == null)
            return false;
        return myset[bucket][bucketSize];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */