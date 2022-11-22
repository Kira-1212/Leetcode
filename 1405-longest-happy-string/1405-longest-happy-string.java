class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[1] -x[1]);
        if(a!=0 )
            pq.add(new int[]{0,a});
        if(b!=0)
            pq.add(new int[]{1,b});
        if(c!=0)
            pq.add(new int[]{2,c});
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(sb.length()>1 && (sb.charAt(sb.length()-1) == (char)(curr[0] +'a') && sb.charAt(sb.length()-2) == (char)(curr[0] +'a'))){
                if(pq.isEmpty())
                    break;
                
                int[] curr2 = pq.poll();
                sb.append((char)(curr2[0]+'a'));
                curr2[1]--;
                if(curr2[1]!=0)
                    pq.add(curr2);
            }
            else{
                sb.append((char)(curr[0]+'a'));
                curr[1]--;
                
            }
            if(curr[1]!=0)
                    pq.add(curr);
        }
        return sb.toString();
    }
}