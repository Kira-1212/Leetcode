class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i<tasks.length ; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        int maxCount =0;
        for(Character task : map.keySet()){
            if(maxFreq == map.get(task))
                maxCount++;
        }
        int partitions = maxFreq -1;
        int empty = partitions * (n - (maxCount -1));
        int pending = tasks.length - maxFreq * maxCount;
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
}