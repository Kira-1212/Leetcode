class Solution {
    public int shortestWay(String source, String target) {
        if(source == null || source.length() == 0)return -1;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for( int i =0; i<source.length(); i++){
            char c = source.charAt(i);
            if(!map.containsKey(c))
                map.put(c, new ArrayList());
            map.get(c).add(i);
        }
        int i =0;
        int pos =0;
        int result =1;
        while(i<target.length()){
            if(!map.containsKey(target.charAt(i)))
                return -1;
            List<Integer> li = map.get(target.charAt(i));
            int k = Collections.binarySearch(li, pos);
            if(k<0)
                k =-k -1;
            if( k== li.size()){
                pos =0;
                result++;
            }
            else{
                pos = li.get(k) +1;
                i++;
            }
        }
        return result;
    }
}