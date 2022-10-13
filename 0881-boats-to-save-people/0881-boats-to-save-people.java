class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0;
        int l = 0;
        int r = people.length-1;
        while(l<=r){
            int remaining = limit - people[r];
            r--;
            count++;
            if(l<=r && people[l]<= remaining)
                l++;
        }

        
        return count;
    }
}