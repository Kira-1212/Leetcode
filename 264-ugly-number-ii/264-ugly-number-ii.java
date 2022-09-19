class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long)1);
        set.add((long)1);
        int count = 0;
        long curr = 1;
        int[] primes = {2,3,5};
        
        while(count< n){
            curr = pq.poll();
             count++;
            for( int prime : primes){
                long newcurr = curr * prime;
                if(!set.contains(newcurr)){
                    pq.add(newcurr);
                   
                    set.add(newcurr);
                }
            }
        }
        return (int)curr;
    }
}