class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> b-a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if(!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek())
            large.add(small.poll());
        if(small.size() > large.size() + 1)
            large.add(small.poll());
        if(large.size() > small.size() +1)
            small.add(large.poll());
    }
    
    public double findMedian() {
        if(small.size() < large.size())
            return (double)large.peek();
        if(small.size() > large.size())
            return (double)small.peek();
        return ((double)small.peek() + (double)large.peek() )/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */