class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<ppid.size(); i++){
            if(ppid.get(i) > 0){
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        q.add(kill);
        while(!q.isEmpty()){
            int curr = q.poll();
            l.add(curr);
            if(map.containsKey(curr)){
                for(int i : map.get(curr)){
                    q.add(i);
                }
            }
        }
        return l;
    }
}