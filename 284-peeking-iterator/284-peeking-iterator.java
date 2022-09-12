// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer el;
    private Iterator<Integer> itr = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.itr = iterator;
        next();    
    }
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return el;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	     Integer temp = el;
        if(itr.hasNext())
            el = itr.next();
        else
            el = null;
        return temp;
	}
	
	@Override
	public boolean hasNext() {
	    return el != null;
	}
}