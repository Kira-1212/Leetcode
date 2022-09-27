class TopVotedCandidate {
    HashMap<Integer,Integer> votes;
    HashMap<Integer,Integer> leading;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        votes = new HashMap<>();
        leading = new HashMap<>();
        this.times = times;
        int leader = persons[0];
        for(int i = 0; i<persons.length; i++){
            votes.put(persons[i], votes.getOrDefault(persons[i], 0)+1);
            if(votes.get(persons[i])>=votes.get(leader)){
                leader = persons[i];
            }
            leading.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        if(leading.containsKey(t))return leading.get(t);
        int low = 0, high = times.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(t>times[mid])
                low = mid + 1;
            else
                high = mid -1;
        }
        return leading.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */