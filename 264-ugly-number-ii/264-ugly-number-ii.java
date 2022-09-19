// class Solution {
//     public int nthUglyNumber(int n) {
//         if(n == 1) return 1;
//         HashSet<Long> set = new HashSet<>();
//         PriorityQueue<Long> pq = new PriorityQueue<>();
//         pq.add((long)1);
//         set.add((long)1);
//         int count = 0;
//         long curr = 1;
//         int[] primes = {2,3,5};
        
//         while(count< n){
//             curr = pq.poll();
//              count++;
//             for( int prime : primes){
//                 long newcurr = curr * prime;
//                 if(!set.contains(newcurr)){
//                     pq.add(newcurr);
                   
//                     set.add(newcurr);
//                 }
//             }
//         }
//         return (int)curr;
//     }
// }

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int n2 = 2, n3 = 3, n5 = 5;
        int p3 =0, p2 =0, p5 =0;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i<n; i++){
            int min = Math.min(n2, Math.min(n3,n5));
            result[i] = min;
            if(n2 == min){
                p2++;
                n2 = result[p2] * 2;
                
                
            }
            if(n3 == min){
                p3++;
                n3 = result[p3] * 3;
                
                
            }
            if(n5 == min){
                p5++;
                n5 = result[p5] * 5;
                
                
            }
        }
        return result[n-1];
    }
}