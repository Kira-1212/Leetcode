class MovingAverage {
    Queue<Integer> q ;
    int capacity;
    int sum;
    public MovingAverage(int size) {
        capacity = size;
        q = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        if(q.size() == capacity){
            sum-=q.poll();

        }
        sum+=val;
        q.add(val);
        return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */